package app

// 基本的にJavaの記法
// import react from 'react';

import external.materialui.*
import kotlinx.html.InputType
import kotlinx.html.js.*

import react.dom.div
import react.dom.input
import react.dom.button
import react.dom.h3
import react.dom.ul
import react.dom.p
import react.dom.li
import react.ReactElement

// パッケージをインポート

import org.w3c.dom.HTMLInputElement
import react.*


interface Props: RProps {
    var initialItems: List<String?>
}

interface State: RState {
    var items: List<String?>
    var text: String
}

class App(props: Props) : RComponent<Props, State>(props) {
    // stateの初期化
    override fun State.init(props: Props) {
        items = props.initialItems
        text = ""
    }

    override fun RBuilder.render() {
        AppBar {
            h3 {
                +"Kotlin App"
            }
        }



        div("App-item"){
            TextField {
                // DOMの属性、値などはここに書いていく
                attrs {
                    value = state.text
                    label = "Add todo item"
                    onChange = {
                        val target = it.target as HTMLInputElement
                        setState {
                            text = target.value
                        }
                    }
                }
            }
        }
        div {
            Button {
                +"Add"
                attrs {
                    onClick = {
                        if (state.text.isNotEmpty()) {
                            setState {
                                items += text
                                text = ""
                            }
                        }
                    }
                    disabled = state.text.isEmpty()
                }
            }
        }

        div("App-item-wrapper"){
            MList {
                // withIndexでindexも一緒にマッピングする
                for ((index, item) in state.items.withIndex()) {
                    MListItem {
                        key = index.toString()
//                        attrs {
//                            +item.toString()
//                        }
                        MListItemText {
                            attrs {
                                primary = p {
                                        +item.toString()
                                }
                            }
                        }

                        Button {
                            +"削除"
                            attrs {
                                onClick = {
                                    setState {
                                        // インデックスと異なるリストのみを残す（フィルタする）。
                                        items = items.filterIndexed { i, _ -> i != index }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.app(items:List<String?> = kotlin.collections.mutableListOf()) = child(App::class) {
    attrs.initialItems = items
}