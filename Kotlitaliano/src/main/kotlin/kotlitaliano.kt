import java.io.Serializable

// Print-related extensions
inline fun stampa(testo: String) = print(testo)
inline fun stampaLinea(testo: String) = println(testo)

// Read input
inline fun leggiLinea(): String? = readLine()

// Collections
inline fun <reified T> arrayDi(vararg elementi: T): Array<T> = arrayOf(*elementi)
//fun <T> listaDi(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
inline fun <reified T>  listaDi(vararg elementi: T): List<T> = listOf(*elementi)
inline fun <K, V> mappaDi(vararg coppie: Pair<K, V>): Map<K, V> = mapOf(*coppie)
inline fun <T> insiemeDi(vararg elementi: T): Set<T> = setOf(*elementi)
inline fun <T> listaMutabileDi(vararg elementi: T): MutableList<T> = mutableListOf(*elementi)
inline fun <K, V> mappaMutabileDi(vararg coppie: Pair<K, V>): MutableMap<K, V> = mutableMapOf(*coppie)
inline fun <T> insiemeMutabileDi(vararg elementi: T): MutableSet<T> = mutableSetOf(*elementi)

// Control flow (for demonstration purposes, these redirect to their English counterparts)
inline fun <T> se(condizione: Boolean, blocco: () -> T): T? = if (condizione) blocco() else null
inline fun <T> altrimenti(blocco: () -> T): T = blocco()

// Mathematical operations
inline fun Int.piu(altro: Int): Int { return  this.plus(altro) }
inline fun Int.meno(altro: Int): Int = this.minus(altro)
inline fun Int.moltiplica(altro: Int): Int = this.times(altro)
inline fun Int.dividi(altro: Int): Int = this.div(altro)
inline fun Int.modulo(altro: Int): Int = this.mod(altro)

// Logical operations
inline fun Boolean.non(): Boolean = !this
infix fun Boolean.e(altro: Boolean): Boolean = this && altro
infix fun Boolean.o(altro: Boolean): Boolean = this || altro

// Object equality
inline fun <T> T.uguale(ad: T): Boolean = this == ad
inline fun <T> T.nonUguale(ad: T): Boolean = this != ad

// Overrides
inline fun Any.aStringa(): String = this.toString()
inline fun Any.codiceHash(): Int = this.hashCode()

// Italian-style 'while' loop
inline fun mentre(condizione: Boolean, azione: () -> Unit) {
    while (condizione) {
        azione()
    }
}

// Italian-style 'for' loop
inline fun <T> per(collezione: Iterable<T>, azione: (T) -> Unit) {
    for (elemento in collezione) {
        azione(elemento)
    }
}

// Filter - "filtra"
inline fun <T> List<T>.filtra(predicate: (T) -> Boolean): List<T> = this.filter(predicate)

// Map - "mappa"
inline fun <T, R> List<T>.mappa(transform: (T) -> R): List<R> = this.map(transform)

// Sort - "ordina"
inline fun <T : Comparable<T>> List<T>.ordina(): List<T> = this.sorted()

// SortBy - "ordinaPer"
inline fun <T, R : Comparable<R>> List<T>.ordinaPer(crossinline selector: (T) -> R?): List<T> = this.sortedBy(selector)

// Reverse - "inverti"
inline fun <T> List<T>.inverti(): List<T> = this.reversed()

// ForEach - "perOgni"
inline fun <T> List<T>.perOgni(azione: (T) -> Unit) = this.forEach(azione)

// Reduce - "riduci"
inline fun <T, R> List<T>.riduci(accumulatore: R, operazione: (acc: R, T) -> R): R = this.fold(accumulatore, operazione)

// Fold - "accumula"
inline fun <T, R> List<T>.accumula(accumulatore: R, operazione: (acc: R, T) -> R): R = this.fold(accumulatore, operazione)

// Any - "qualunque"
inline fun <T> List<T>.qualunque(predicate: (T) -> Boolean): Boolean = this.any(predicate)

// All - "tutti"
inline fun <T> List<T>.tutti(predicate: (T) -> Boolean): Boolean = this.all(predicate)

// None - "nessuno"
inline fun <T> List<T>.nessuno(predicate: (T) -> Boolean): Boolean = this.none(predicate)

// Find - "trova"
inline fun <T> List<T>.trova(predicate: (T) -> Boolean): T? = this.find(predicate)

// First - "primo"
inline fun <T> List<T>.primo(predicate: (T) -> Boolean): T = this.first(predicate)

// Last - "ultimo"
inline fun <T> List<T>.ultimo(predicate: (T) -> Boolean): T = this.last(predicate)

// Pair equivalent: "Coppia"
public data class Coppia<out A, out B>(
    public val primo: A,
    public val secondo: B
) : Serializable {

    /**
     * Returns string representation of the [Pair] including its [primo] and [secondo] values.
     */
    public override fun toString(): String = "($primo, $secondo)"
}

data class Tripletta<out A, out B, out C>(
    val primo: A,
    val secondo: B,
    val terzo: C
) : Serializable {

    /**
     * Returns string representation of the [Triple] including its [primo], [secondo] and [terzo] values.
     */
    public override fun toString(): String = "($primo, $secondo, $terzo)"
}


// Access Pair components: "primo" and "secondo"
inline fun <reified A, reified B> Pair<A, B>.primo(): A = this.first
inline fun <reified A, reified B> Pair<A, B>.secondo(): B = this.second

// Triple equivalent: "Tripla"
fun <A, B, C> tripla(primo: A, secondo: B, terzo: C): Triple<A, B, C> = Triple(primo, secondo, terzo)

// Access Triple components: "primo", "secondo", "terzo"
val <A, B, C> Triple<A, B, C>.primo: A get() = this.first
val <A, B, C> Triple<A, B, C>.secondo: B get() = this.second
val <A, B, C> Triple<A, B, C>.terzo: C get() = this.third

// Extensions for List
inline fun <reified T> List<T>.dimensione(): Int = this.size

//val <T> List<T>.dimensione: Int
//  get() = this.size

inline fun <reified T> List<T>.primo(): T = this.first()

inline fun <reified T> List<T>.ultimo(): T = this.last()

inline fun <reified T> List<T>.eVuota(): Boolean = this.isEmpty()

inline fun <reified T> List<T>.noneVuota(): Boolean = this.isNotEmpty()

inline fun <reified T> List<T>.ottieni(indice: Int): T = this[indice] // Equivalent of `get`
inline fun <reified T> MutableList<T>.imposta(indice: Int, valore: T) { this[indice] = valore } // Equivalent of `set`

// Extensions for String
inline fun String.ottieni(indice: Int): Char = this[indice] // Equivalent of `get`

inline fun String.inMaiuscolo(): String = this.uppercase() // Equivalent of `uppercase`

inline fun String.inMinuscolo(): String = this.lowercase() // Equivalent of `lowercase`

inline fun String.sostituisci(antico: String, nuovo: String): String = this.replace(antico, nuovo) // Equivalent of `replace`
