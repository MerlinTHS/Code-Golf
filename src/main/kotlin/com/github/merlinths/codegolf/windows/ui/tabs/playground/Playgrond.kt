package com.github.merlinths.codegolf.windows.ui.tabs.playground

import com.github.merlinths.codegolf.MyBundle
import com.github.merlinths.codegolf.service.GolfService
import com.intellij.ui.dsl.builder.panel
import com.github.merlinths.codegolf.windows.ui.components.immutableEditor
import com.intellij.openapi.project.Project
import kotlinx.coroutines.runBlocking

/**
 * Playground UI
 *
 * In the playground the user can set up refactoring - configurations to
 * upload the refactored code to [CodeGolf](https://code.golf/).
 *
 * @return main overview panel
 */
fun playground(
        project: Project,
        onSubmitSolution: () -> Unit
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
        immutableEditor(project)
    }

    group {
        row {
            button(MyBundle.message("submit")) {
                onSubmitSolution()
            }
        }
    }
}