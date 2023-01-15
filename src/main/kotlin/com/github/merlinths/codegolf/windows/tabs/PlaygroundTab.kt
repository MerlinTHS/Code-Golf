package com.github.merlinths.codegolf.windows.tabs

import com.github.merlinths.codegolf.MyBundle
import com.intellij.ui.dsl.builder.panel

class PlaygroundTab : Tab {
    override val title = MyBundle.message("playground")

    override val component = panel {
        row {
            label("In progress...")
        }
    }
}