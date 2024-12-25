fun main() {
    stampaLinea("This is a demo. What's your name?")
    val nome = leggiLinea()
    stampaLinea("Ciao caro amico $nome")

    val lista = listaDi(Coppia("uno", 1), Coppia("due", 2), Coppia("tre", 3))
    val primiElementi = lista.mappa{ it.primo }
    stampaLinea("Primi elementi: $primiElementi")
    val secondiElementi = lista.mappa{ it.secondo }
    stampaLinea("Secondi elementi: $secondiElementi")
    val elementiQuadratici = secondiElementi.mappa { it * it }
    stampaLinea("Elementi quadratici: $elementiQuadratici")
}
