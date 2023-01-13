package com.github.merlinths.codegolf.service

import javax.swing.JComponent

interface GolfEditor {
    val component: JComponent

    fun setCode(code: String)
}