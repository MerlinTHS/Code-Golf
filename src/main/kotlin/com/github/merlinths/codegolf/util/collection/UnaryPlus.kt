package com.github.merlinths.codegolf.util.collection

context(MutableCollection<Type>)
operator fun <Type> Type.unaryPlus() {
    add(this@unaryPlus)
}

context(MutableCollection<Type>)
operator fun <Type> Iterable<Type>.unaryPlus() {
    addAll(this@unaryPlus)
}