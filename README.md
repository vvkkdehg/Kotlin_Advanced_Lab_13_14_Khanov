# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin
## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языкаKotlin,которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
  Все примеры ориентированы на практическое применение и подготовку к разработкемобильных приложений.

## Что было изучено

1. Generics типы:
```kotlin
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)
```
2. Enum классы:
```kotlin
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
```
3. Data классы:
```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
```
4. Singleton-объект (object)
```kotlin
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}
```
5. Extention свойства и функции:
    * Свойство:
    ```kotlin
    val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"
    ```
    * Функция:
    ```kotlin
    fun Quiz.StudentProgress.printProgressBar() {
    repeat(times = Quiz.answered) { print("||") }
    repeat(times = Quiz.total - Quiz.answered) { print("()") }
    println()
    println(Quiz.progressText)
    }
    ```
6. Scope функции:
```kotlin
fun printQuiz() {
    question1.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
        println()
    }

    question2.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
        println()
    }

    question3.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
        println()
    }
}
```
7. Массивы:
```kotlin
val rockPlanets = arrayOf<String>("Mercury", 
    "Venus", "Earth", "Mars")
```
8. Списки:
```kotlin
val solarSystem = listOf(
    "Mercury", "Venus", "Earth", "Mars",
    "Jupiter", "Saturn", "Uranus", "Neptune"
)
```
9. Множества:
```kotlin
val solarSystem = mutableSetOf(
    "Mercury", "Venus", "Earth", "Mars",
    "Jupiter", "Saturn", "Uranus", "Neptune"
)
```
9. Коллекции (Map):
```kotlin
val solarSystem = mutableMapOf(
    "Mercury" to 0,
    "Venus" to 0,
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79,
    "Saturn" to 82,
    "Uranus" to 27,
    "Neptune" to 14
)
```
10. Функции высокого порядка:
```kotlin
fun main() {
    action(n1 = 5, n2 = 3, op = ::sum) // 8
    action(n1 = 5, n2 = 3, op = ::multiply) // 15
    action(n1 = 5, n2 = 3, op = ::subtract) // 2
}

fun action(n1: Int, n2: Int, op: (Int, Int) -> Int) {
    val result = op(n1, n2)
    println(result)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}
```
11. Higher-order functions:
```kotlin
val cookies = listOf(
    Cookie(
        name = "Печенье с шоколадом",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Нуга ореховая",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ))
fun main() {
    cookies.foreach {
        println("Пункт меню: $it")
    }
}
```


## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone https://github.com/vvkkdehg/Kotlin_Advanced_Lab_13_14_Khanov.git
```
## Автор
Ханов Владислав Вячеславович
## Лицензия
Проект создан в учебных целях.