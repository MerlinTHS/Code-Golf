package com.github.merlinths.codegolf.refactoring.renaming.provider.impl.lang

import com.github.merlinths.codegolf.refactoring.renaming.provider.IDProvider
import com.github.merlinths.codegolf.refactoring.renaming.provider.impl.filter.FilteredIDProvider
import java.util.function.Predicate.not

fun IDProvider.forLanguage(
    keywords: Set<String>
) = FilteredIDProvider(
    provider = this,
    filter = not(keywords::contains)
)