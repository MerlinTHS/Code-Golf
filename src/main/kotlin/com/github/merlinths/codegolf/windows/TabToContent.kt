package com.github.merlinths.codegolf.windows

import com.github.merlinths.codegolf.windows.tabs.Tab
import com.intellij.ui.content.ContentFactory

internal fun Tab.toContent() =
    ContentFactory
        .SERVICE.getInstance()
        .createContent(
            component,
            title,
            false
        )
