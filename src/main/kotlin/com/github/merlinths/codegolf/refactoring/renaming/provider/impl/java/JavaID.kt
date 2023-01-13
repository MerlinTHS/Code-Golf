package com.github.merlinths.codegolf.refactoring.renaming.provider.impl.java

import com.github.merlinths.codegolf.util.collection.unaryPlus

object JavaID {
    val startCharacters = buildSet<Char> {
        + '_'
        + '$'
        + ('a'..'z')
        + ('A'..'Z')
    }

    val commonCharacters = buildSet<Char> {
        + startCharacters
        + ('0'..'9')
    }
}