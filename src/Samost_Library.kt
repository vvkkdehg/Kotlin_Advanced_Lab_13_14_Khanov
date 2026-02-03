data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)
data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)
data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)
sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}
class Library<T> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun getAllItems(): List<T> = items.toList()
}
fun filterByYear(books: List<LibraryItem.BookItem>, year: Int): List<LibraryItem.BookItem> {
    return books.filter { it.book.year == year }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy {
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }
}

fun groupByAuthor(books: List<LibraryItem.BookItem>): Map<String, List<LibraryItem.BookItem>> {
    return books.groupBy { it.book.author }
}

fun calculateTotalDuration(dvds: List<LibraryItem.DVDItem>): Int {
    return dvds.fold(0) { total, dvdItem -> total + dvdItem.dvd.duration }
}

fun main() {
    val library = Library<LibraryItem>()

    val books = listOf(
        Book("Преступление и наказание", "Федор Достоевский", 1866, "123-456"),
        Book("Идиот", "Федор Достоевский", 1869, "654-321"),
        Book("Горе от ума", "Александр Грибоедов", 1824, "333-444"),
        Book("Палата №6", "Антон Чехов", 1892, "555-666"))

    val magazines = listOf(
        Magazine("Мурзилка", 64, "Май"),
        Magazine("Непоседа", 36, "Сентябрь"))

    val dvds = listOf(
        DVD("Борат", "Ларри Чарльз", 84),
        DVD("Чародеи", "Константин Бромберг", 147),
        DVD("Форсаж 6", "Джастин Лин ", 130))

    books.forEach { library.addItem(LibraryItem.BookItem(it)) }
    dvds.forEach { library.addItem(LibraryItem.DVDItem(it)) }
    magazines.forEach { library.addItem(LibraryItem.MagazineItem(it)) }

    val allItems = library.getAllItems()
    val bookItems = books.map { LibraryItem.BookItem(it) }
    println("Книги написанные в 1869 году:")
    val itog = filterByYear(bookItems, 1869)
    itog.forEach { println(it.book.title) }
    println()
    println("Отсортированные по имени элементы библиотеки:")
    val itog2 = sortByTitle(allItems)
    itog2.forEach { item ->
        val vyvod = when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
        println(vyvod)
    }
    println()
    println("Книги, сгруппированные по автору:")
    val itog3 = groupByAuthor(bookItems)
    itog3.forEach { (i, j) ->
        println("$i:")
        j.forEach { println("- ${it.book.title}") }
    }
    println()
    val dvdItems = dvds.map { LibraryItem.DVDItem(it) }
    val itog4 = calculateTotalDuration(dvdItems)
    println("Общая продолжительность всех DVD: $itog4 минут")
}