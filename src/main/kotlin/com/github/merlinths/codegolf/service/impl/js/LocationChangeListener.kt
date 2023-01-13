package com.github.merlinths.codegolf.service.impl.js

import com.intellij.ui.jcef.JBCefBrowser

fun JBCefBrowser.addLocationChangeListener(onLocationChange: String) {
    cefBrowser.executeJavaScript(
        """
            window.addEventListener('locationchange', function(){
                alert('Location changed!');
            });
               window.addEventListener('popstate', function (event) {
                alert('URL change');
               });
        """.trimIndent(),
        cefBrowser.url,
        0
    )
}