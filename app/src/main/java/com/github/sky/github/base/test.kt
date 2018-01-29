package com.github.sky.github.base

/**
 * Created by fuyuxian on 2018/1/18.
 */


open class Animal(val size: Int)

class Dog(val cuteness: Int) : Animal(100)
class Spider(val terrorFactor: Int) : Animal(1)

val dogList: List<Dog> = listOf(Dog(10), Dog(20))
val animalList: List<Animal> = dogList

fun <T> copyData(source: List<T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun anim() {
    val array = ArrayList<Dog>()
    val animals = ArrayList<Animal>()
    array.add(Dog(4))
//    array.add(Spider(5))

    copyData(array, animals)

//    val anims: ArrayList<Animal> = array

    val com = object : Comparable<Animal> {
        override fun compareTo(other: Animal): Int {
            return other.size
        }

    }

    val list: MutableList<out Number> = ArrayList()


}

fun <T> aa(t: T) {

}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0f)

    val y: Comparable<Float> = x
    y.compareTo(3f)

    aa<String>("sdf")


}