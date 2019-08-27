// JSモジュールをインポート
@file:JsModule("@material-ui/core/List")

// material-uiとしてパッケージ化
package external.materialui

import react.RClass
import react.RProps

@JsName("default")

// renderで使えるDOMとしてエクスポートする
external val MList: RClass<ListProps>

// 必要なpropsを指定
external interface ListProps : RProps {
}



