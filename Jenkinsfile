pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK11'
    }

    stages {
        // Шаг 1: Получение кода из Git
        stage('Checkout') {
            steps {
                git branch: 'feature/4', url: 'https://github.com/provok4tor/-2.-.01---.git '
            }
        }

        // Шаг 2: Компиляция кода
        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        // Шаг 3: Запуск тестов (только для feature-веток)
        stage('Test') {
    when {
        expression { 
            // Проверяем наличие "feature" в любом месте имени ветки
            return env.BRANCH_NAME != null && env.BRANCH_NAME.contains("feature") 
        }
    }
    steps {
        script {
            echo "Running tests for branch: ${env.BRANCH_NAME}"
            bat 'mvn test'
            junit '**/surefire-reports/*.xml'
        }
    }
}

        // Шаг 4: Статический анализ (только для dev)
        stage('Static Analysis') {
            when {
                branch 'dev'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }

        // Шаг 5: Измерение покрытия
        stage('Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        // Шаг 6: Установка в локальный репозиторий (только при успехе)
        stage('Install') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                bat 'mvn install -DskipTests'
            }
        }

        // Шаг 7: Проверка покрытия (минимум 60%)
        stage('Coverage Check') {
            steps {
                bat 'mvn jacoco:check'
            }
        }

        // Шаг 8: Публикация артефактов
        stage('Publish') {
            steps {
                bat 'if not exist "C:\\ArtifactsForLab5" mkdir "C:\\ArtifactsForLab5"'
                bat 'copy /Y "aggregator\\target\\*.jar" "C:\\ArtifactsForLab5\\"'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/*.xml'  // Публикация отчетов тестов
        }
    }
}
