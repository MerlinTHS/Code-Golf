package com.github.merlinths.codegolf.service.impl

fun String.escape() =
    replace("\${", "\\" + "\${")