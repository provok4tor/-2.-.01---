pipeline {
    agent any

    stages {
        // Шаг 1: Получение кода из Git
        stage('Checkout') {
            steps {
                git branch: 'feature/4', url: 'https://github.com/ваш-репозиторий.git'
            }
        }

        // Шаг 2: Компиляция
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        // Шаг 3: Запуск тестов (только для feature-веток)
        stage('Test') {
            when {
                branch 'feature/*'
            }
            steps {
                sh 'mvn test'
            }
        }

        // Шаг 4: Статический анализ (только для dev)
        stage('Static Analysis') {
            when {
                branch 'dev'
            }
            steps {
                sh 'mvn checkstyle:check' // Или PMD/SpotBugs
            }
        }

        // Шаг 5: Измерение покрытия
        stage('Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        // Шаг 6: Установка в локальный репозиторий
        stage('Install') {
            steps {
                sh 'mvn install -DskipTests'
            }
        }

        // Шаг 7: Проверка покрытия (минимум 60%)
        stage('Coverage Check') {
            steps {
                sh 'mvn jacoco:check'
            }
        }

        // Шаг 8: Публикация артефактов
        stage('Publish') {
            steps {
                sh 'cp aggregator/target/*.jar /путь/к/папке/артефактов'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}