package com.github.merlinths.codegolf.windows.tabs

import javax.swing.JComponent

interface Tab {
    val title: String
    val component: JComponent
}