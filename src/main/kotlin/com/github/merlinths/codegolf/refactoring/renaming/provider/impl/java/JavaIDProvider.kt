package com.github.merlinths.codegolf.refactoring.renaming.provider.impl.java

import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.SetBasedIDProvider
import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.lang.forLanguage

fun createJavaIDProvider() =
    SetBasedIDProvider(
        startCharacters = JavaID.startCharacters,
        commonCharacters = JavaID.commonCharacters
    ).forLanguage(
        keywords = JavaKeywords
    )