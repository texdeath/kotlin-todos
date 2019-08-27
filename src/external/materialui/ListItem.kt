// JSモジュールをインポート
@file:JsModule("@material-ui/core/ListItem")

// material-uiとしてパッケージ化
package external.materialui

import react.RClass
import react.RProps

@JsName("default")

// renderで使えるDOMとしてエクスポートする
external val MListItem: RClass<ListItemProps>

// 必要なpropsを指定
external interface ListItemProps : RProps {
    var alignItems: String?
    var button: Boolean?
    var ContainerComponent: dynamic
    var ContainerProps: RProps?
    var dense: Boolean?
    var disabled: Boolean?
    var disableGutters: Boolean?
    var divider: Boolean?
    var selected: Boolean?
}



