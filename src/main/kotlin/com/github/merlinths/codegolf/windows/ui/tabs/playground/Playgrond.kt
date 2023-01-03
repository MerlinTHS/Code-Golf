package com.github.merlinths.codegolf.windows.ui.tabs.playground

import com.github.merlinths.codegolf.MyBundle
import com.intellij.ui.dsl.builder.panel
import com.github.merlinths.codegolf.windows.ui.components.immutableEditor

/**
 * Playground UI
 *
 * In the playground the user can set up refactoring - configurations to
 * upload the refactored code to [CodeGolf](https://code.golf/).
 *
 * @param[code] Code after CodeGolf refactoring
 * @return main overview panel
 */
fun playground(
        code: String
) = panel {
    group(MyBundle.message("settings")) {
        row {
            checkBox(MyBundle.message("rename_variables"))
        }

        row {
            checkBox(MyBundle.message("minify"))
        }
    }

    group(MyBundle.message("preview")) {
        immutableEditor(code)
    }
}