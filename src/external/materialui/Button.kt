// JSモジュールをインポート
@file:JsModule("@material-ui/core/Button")

// material-uiとしてパッケージ化
package external.materialui

import react.RClass
import react.RProps

@JsName("default")

// renderで使えるDOMとしてエクスポートする
external val Button: RClass<ButtonProps>

// 必要なpropsを指定
external interface ButtonProps : RProps {
    var onClick: () -> Unit
    var disabled: Boolean
}



