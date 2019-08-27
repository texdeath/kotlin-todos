// JSモジュールをインポート
@file:JsModule("@material-ui/core/AppBar")

// material-uiとしてパッケージ化
package external.materialui

import react.RClass
import react.RProps

@JsName("default")

// renderで使えるDOMとしてエクスポートする
external val AppBar: RClass<AppBarProps>

// 必要なpropsを指定
external interface AppBarProps : RProps {

}



