/*
* El programa imprimir dobles de
* números que van del 1 al 10.
*
**/


object DoublesOfNumbers extends App {

    val double: (Int => Int) = _ * 2
    (1 to 10) foreach double .andThen(println)

}
