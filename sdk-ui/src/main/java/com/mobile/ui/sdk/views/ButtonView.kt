package com.mobile.ui.sdk.views

import android.content.Context
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.mobile.ui.sdk.R
import com.mobile.ui.sdk.utils.Fonts


interface ButtonViewInterface {
    fun onClick(state: Int)
}


class ButtonView(context: Context, attrs: AttributeSet): RelativeLayout(context, attrs), ButtonViewInterface {

    var state_current_button = 0

    val COLOR_DEFAUL_TEXT_BG  = context.resources.getColor(R.color.white)
    val COLOR_DEFAUL_TEXT_BORDER  = context.resources.getColor(R.color.quilmes)
    val COLOR_DEFAUL_BG  = context.resources.getDrawable(R.drawable.button_round)
    val COLOR_DEFAUL_BORDER  = context.resources.getDrawable(R.drawable.button_border_round)


        init {
            inflate(context, R.layout.button_view, this)

            val attributes = context.obtainStyledAttributes(attrs, R.styleable.ButtonView)

            val button_primary: LinearLayout = findViewById(R.id.button_primary)
            val text_button_primary: TextView = findViewById(R.id.button_text_primary)

            val button_secondary: LinearLayout = findViewById(R.id.button_secondary)
            val text_button_secondary: TextView = findViewById(R.id.button_text_secondary)
            val icon_button_secondary: ImageView = findViewById(R.id.button_icon_secondary)

            val button_icon: LinearLayout = findViewById(R.id.button_icon)
            val button_icon_only: ImageView = findViewById(R.id.button_icon_only)


            val button_text: LinearLayout = findViewById(R.id.button_text)
            val text_button_only: TextView = findViewById(R.id.button_text_only)

            val title =  attributes.getString(R.styleable.ButtonView_button_title)
            val size =  attributes.getInteger(R.styleable.ButtonView_button_size,0)
            val type =  attributes.getInteger(R.styleable.ButtonView_button_type,0)
            val specification =  attributes.getInteger(R.styleable.ButtonView_button_specification,0)
            val background =  attributes.getInteger(R.styleable.ButtonView_button_background,0)
            val border =  attributes.getInteger(R.styleable.ButtonView_button_border,0)
            var textColor =  attributes.getInteger(R.styleable.ButtonView_button_text_color,0)
            var tintColor =  attributes.getInteger(R.styleable.ButtonView_button_tint_color,0)
            var icon =  attributes.getInteger(R.styleable.ButtonView_button_icon,0)

            val params = button_primary.layoutParams

            text_button_primary.typeface = Fonts(resources).roboto_regular

            when(type){
                TYPE_PRIMARY -> {
                    button_primary.visibility = View.VISIBLE
                    button_secondary.visibility = View.GONE
                    button_icon.visibility = View.GONE
                    button_text.visibility = View.GONE

                    text_button_primary.text = title
                    when(specification){
                        ESPECIFICATIONN_WITH_BG -> {
                            if(textColor== DEFAULT){
                                textColor = COLOR_DEFAUL_TEXT_BG
                            }
                            if(background == DEFAULT ){
                                button_primary.setBackgroundDrawable(COLOR_DEFAUL_BG)
                            }else{
                                button_primary.setBackgroundResource(background)
                            }

                        }
                        ESPECIFICATIONN_ONLY_BORDER -> {
                            if(textColor== DEFAULT){
                                textColor = COLOR_DEFAUL_TEXT_BORDER
                            }
                            if(background == DEFAULT ){
                                button_primary.setBackgroundDrawable(COLOR_DEFAUL_BORDER)
                            }else{
                                button_primary.setBackgroundResource(border)
                            }
                        }
                    }
                    text_button_primary.setTextColor(textColor)
                    when(size){
                        SMALL -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_SMALL)
                        }
                        MEDIUM -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_MEDIUM)
                        }
                        LARGE -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_LARGE)
                        }
                    }
                    button_primary.layoutParams = params
                }
                TYPE_SECONDARY -> {
                    button_primary.visibility = View.GONE
                    button_secondary.visibility = View.VISIBLE
                    button_icon.visibility = View.GONE
                    button_text.visibility = View.GONE

                    text_button_secondary.text = title
                    when(specification){
                        ESPECIFICATIONN_WITH_BG -> {
                            if(textColor== DEFAULT){
                                textColor = COLOR_DEFAUL_TEXT_BG
                                tintColor = COLOR_DEFAUL_TEXT_BG
                            }
                            if(background == DEFAULT ){
                                button_secondary.setBackgroundDrawable(COLOR_DEFAUL_BG)
                            }else{
                                button_secondary.setBackgroundResource(background)
                            }

                        }
                        ESPECIFICATIONN_ONLY_BORDER -> {
                            if(textColor== DEFAULT){
                                textColor = COLOR_DEFAUL_TEXT_BORDER
                                tintColor = COLOR_DEFAUL_TEXT_BORDER
                            }
                            if(background == DEFAULT){
                                button_secondary.setBackgroundDrawable(COLOR_DEFAUL_BORDER)
                            }else{
                                button_secondary.setBackgroundResource(border)
                            }
                        }
                    }

                    if(icon == DEFAULT){
                        icon = R.drawable.ic_info
                    }

                    icon_button_secondary.setImageResource(icon)
                    icon_button_secondary.setColorFilter(tintColor)
                    text_button_secondary.setTextColor(textColor)
                    when(size){
                        SMALL -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_SMALL)
                        }
                        MEDIUM -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_MEDIUM)
                        }
                        LARGE -> {
                            params!!.height = convertPixelToPoints(SIZE_HEIGHT)
                            params.width = convertPixelToPoints(SIZE_WIDTH_LARGE)
                        }
                    }
                    button_secondary.layoutParams = params;
                }
                TYPE_ICON ->{
                    button_primary.visibility = View.VISIBLE
                    button_secondary.visibility = View.GONE
                    button_icon.visibility = View.VISIBLE
                    button_text.visibility = View.GONE
                    when(specification){
                        ESPECIFICATIONN_WITH_BG -> {
                            if(tintColor == DEFAULT){
                                tintColor = COLOR_DEFAUL_TEXT_BG
                            }
                            if(background == DEFAULT ){
                                button_icon.setBackgroundDrawable(COLOR_DEFAUL_BG)
                            }else{
                                button_icon.setBackgroundResource(background)
                            }

                        }
                        ESPECIFICATIONN_ONLY_BORDER -> {
                            if(tintColor== DEFAULT){
                                tintColor = COLOR_DEFAUL_TEXT_BORDER
                            }
                            if(background == DEFAULT){
                                button_icon.setBackgroundDrawable(COLOR_DEFAUL_BORDER)
                            }else{
                                button_icon.setBackgroundResource(border)
                            }
                        }
                    }

                    if(icon == DEFAULT){
                        icon = R.drawable.ic_info
                    }

                    button_icon_only.setImageResource(icon)
                    button_icon_only.setColorFilter(tintColor)
                }
                TYPE_TEXT -> {
                    button_primary.visibility = View.GONE
                    button_secondary.visibility = View.GONE
                    button_icon.visibility = View.GONE
                    button_text.visibility = View.VISIBLE

                    button_text.setBackgroundResource(0)

                    val content = SpannableString(title)
                    content.setSpan(UnderlineSpan(), 0, content.length, 0)
                    text_button_only.text = content

                    if(textColor == DEFAULT){
                        textColor = COLOR_DEFAUL_TEXT_BORDER
                    }
                    text_button_only.setTextColor(textColor)

                }
        }

        attributes.recycle()

    }

    companion object {
        const val SMALL = 0
        const val MEDIUM  = 1
        const val LARGE  = 2

        const val SIZE_WIDTH_SMALL  = 156
        const val SIZE_WIDTH_MEDIUM = 264
        const val SIZE_WIDTH_LARGE  = 328

        const val SIZE_HEIGHT  = 48

        const val ESPECIFICATIONN_WITH_BG      = 0
        const val ESPECIFICATIONN_ONLY_BORDER  = 1
        const val ESPECIFICATIONN_ONLY_TEXT    = 2
        const val ESPECIFICATIONN_ONLY_ICON    = 3

        const val TYPE_PRIMARY      = 0
        const val TYPE_SECONDARY    = 1
        const val TYPE_ICON         = 2
        const val TYPE_TEXT         = 3

        const val TYPE_SELECT       = 0
        const val TYPE_UNSELECT     = 1

        const val DEFAULT     = 0
    }

    fun convertPixelToPoints(px:Int):Int{
        val displayMetrics = context.getResources().getDisplayMetrics();
        return  ((px*displayMetrics.density) + 0.5).toInt()
    }

    override fun onClick(state: Int) {

    }
}