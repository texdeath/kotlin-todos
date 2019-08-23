// JSモジュールをインポート
@file:JsModule("@material-ui/core/TextField")

// material-uiとしてパッケージ化
package external.materialui

import org.w3c.dom.events.Event
import react.*

@JsName("default")

external val TextField: RClass<TextFieldProps>

// propsを指定
external interface TextFieldProps : RProps {
    var value: String
    var label: String
    var onChange: (e: Event) -> Unit
}