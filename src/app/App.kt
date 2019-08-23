package app

// 基本的にJavaの記法
// import react from 'react';

import kotlinx.html.InputType
import kotlinx.html.js.*

import react.RComponent
import react.RProps
import react.RState
import react.RBuilder
import react.dom.div
import react.dom.input
import react.dom.button
import react.dom.h3
import react.dom.ul
import react.dom.p
import react.dom.li
import react.setState

// パッケージをインポート
import external.materialui.Button
import external.materialui.TextField

import org.w3c.dom.HTMLInputElement

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
        div {
            h3 {
                +"Kotlin App"
            }
        }



        div {
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

        h3 {
            ul {
                // withIndexでindexも一緒にマッピングする
                for ((index, item) in state.items.withIndex()) {
                    li {
                        key = index.toString()
                        p {
                            +item.toString()
                        }
                        button {
                            +"削除"
                            attrs {
                                onClickFunction = {
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