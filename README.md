# Code-Golf

<!-- Plugin description -->
IntelliJ IDEA plugin to 'codegolf' easier!

The plugin minifies your code by removing all the unnecessary whitespaces and renaming
declarations to the shortest names possible.

You can use up to
-  53 single-character names
- 3456 two-character names
- ...

## Usage

Besides some additional context menu actions for minifying code in the current editor right in place, the
plugin adds a tool window with tabs for different types of usage.

### Playground

If you only want to play around a bit, use the Playground tab.
It's editor contains the minified version of the currently edited code.

### Online

This tab contains an embedded chromium browser for interacting directly with [CodeGolf](https://code.golf).

![Tool window home](/screenshots/CodeGolfHome.png)

Whenever you save your code (<kbd>strg</kbd> + <kbd>s</kbd>) the plugin inserts it's minified
version into the selected hole editor.

It also wraps the available languages into an additional
block below details.

![Tool window hole](/screenshots/CodeGolfExampleHole.png)

## Supported languages
- Java

<!-- Plugin description end -->

## Installation
  
- Manually:

  Download the [latest release](https://github.com/MerlinTHS/Code-Golf/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>
  
## Roadmap

- Browser extension which connects IntelliJ and your favorite browser.

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
