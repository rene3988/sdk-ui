package com.mobile.ui.sdk.views

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.CardView
import android.text.Html
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.mobile.ui.sdk.R
import com.mobile.ui.sdk.utils.Fonts
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_custom_view.view.*
import kotlin.properties.Delegates


@RequiresApi(Build.VERSION_CODES.O)
class CardCustomView(context: Context, attrs: AttributeSet): RelativeLayout(context, attrs) {

    val COLOR_DEFAULT  = context.resources.getColor(R.color.victoria)
    val COLOR_DEFAULT_SECONDARY  = context.resources.getColor(R.color.corona)
    val COLOR_DEFAULT_GRAY  = context.resources.getColor(R.color.quilmes)
    val COLOR_DEFAULT_GRAY_LIGHT  = context.resources.getColor(R.color.ultra)

    init {
        inflate(context, R.layout.card_custom_view, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CardCustomView)

        val title =  attributes.getString(R.styleable.CardCustomView_card_title)
        val subtitle =  attributes.getString(R.styleable.CardCustomView_card_subtitle)
        val description =  attributes.getString(R.styleable.CardCustomView_card_description)
        val caption =  attributes.getString(R.styleable.CardCustomView_card_caption)
        val uri =  attributes.getString(R.styleable.CardCustomView_card_uri)
        val holder =  attributes.getInteger(R.styleable.CardCustomView_card_holder,0)
        val icon =  attributes.getInteger(R.styleable.CardCustomView_card_icon,0)
        val border =  attributes.getInteger(R.styleable.CardCustomView_card_border_color,0)
        val titleButton =  attributes.getString(R.styleable.CardCustomView_card_title)
        val iconTint =  attributes.getInteger(R.styleable.CardCustomView_card_icon,0)

        val title_color_text =  attributes.getInteger(R.styleable.CardCustomView_card_title_text_color,0)
        val caption_color_text =  attributes.getInteger(R.styleable.CardCustomView_card_caption_text_color,0)
        val description_color_text =  attributes.getInteger(R.styleable.CardCustomView_card_descriptioncaption_text_color,0)
        val subtitle_color_text =  attributes.getInteger(R.styleable.CardCustomView_card_subtitle_text_color,0)
        val button_color_text =  attributes.getInteger(R.styleable.CardCustomView_card_button_text_color,0)

        val type =  attributes.getInteger(R.styleable.CardCustomView_card_type,0)
        val state =  attributes.getInteger(R.styleable.CardCustomView_card_state,0)

        // TYPE_ONLY_IMAGE
        val contenOnlyImage: RelativeLayout = findViewById(R.id.contenOnlyImage)
        val imageOnlyImage: ImageView = findViewById(R.id.imageOnlyImage)

        // TYPE_FULL_WITH_IMAGE
        val contenFullWithImage: RelativeLayout = findViewById(R.id.contenFullWithImage)
        val titleFullWithImage: TextView = findViewById(R.id.titleFullWithImage)
        val imageFullWithImage: ImageView = findViewById(R.id.imageFullWithImage)
        val descriptionFullWithImage: TextView = findViewById(R.id.descriptionFullWithImage)
        val captionFullWithImage: TextView = findViewById(R.id.captionFullWithImage)

        // TYPE_FULL_WITH_IMAGE_BORDER
        val contenFullWithImageBorder: RelativeLayout = findViewById(R.id.contenFullWithImageBorder)
        val cardMaskFullWithImageBorder: CardView = findViewById(R.id.cardMaskFullWithImageBorder)
        val titleFullWithImageBorder: TextView = findViewById(R.id.titleFullWithImageBorder)
        val imageFullWithImageBorder: ImageView = findViewById(R.id.imageFullWithImageBorder)
        val descriptionFullWithImageBorder: TextView = findViewById(R.id.descriptionFullWithImageBorder)
        val captionFullWithImageBorder: TextView = findViewById(R.id.captionFullWithImageBorder)

        // TYPE_SQUARE_ONLY_IMAGE
        val contenSquareOnlyImage: RelativeLayout = findViewById(R.id.contenSquareOnlyImage)
        val imageSquareOnlyImage: ImageView = findViewById(R.id.imageSquareOnlyImage)

        // TYPE_SQUARE_ICON_CENTER
        val contenSquareIconCenter: RelativeLayout = findViewById(R.id.contenSquareIconCenter)
        val iconSquareIconCenter: ImageView = findViewById(R.id.iconSquareIconCenter)
        val titleSquareIconCenter: TextView = findViewById(R.id.titleSquareIconCenter)
        val subtitleSquareIconCenter: TextView = findViewById(R.id.subtitleSquareIconCenter)

        // TYPE_SQUARE_ICON_LEFT
        val contenSquareIconLeft: RelativeLayout = findViewById(R.id.contenSquareIconLeft)
        val iconSquareIconLeft: ImageView = findViewById(R.id.iconSquareIconLeft)
        val titleSquareIconLeft: TextView = findViewById(R.id.titleSquareIconLeft)
        val captionSquareIconLeft: TextView = findViewById(R.id.captionSquareIconLeft)
        val descriptionSquareIconLeft: TextView = findViewById(R.id.descriptionSquareIconLeft)

        // TYPE_MEDIUM_WITH_IMAGE
        val contenMediumWithImage: RelativeLayout = findViewById(R.id.contenMediumWithImage)
        val titleMediumWithImage: TextView = findViewById(R.id.titleMediumWithImage)
        val imageMediumWithImage: ImageView = findViewById(R.id.imageMediumWithImage)
        val descriptionMediumWithImage: TextView = findViewById(R.id.descriptionMediumWithImage)
        val captionMediumWithImage: TextView = findViewById(R.id.captionMediumWithImage)
        val buttonMediumWithImage: Button = findViewById(R.id.buttonMediumWithImage)


        when(type){
            TYPE_ONLY_IMAGE -> {

                contenOnlyImage.visibility = View.VISIBLE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconCenter.visibility = View.GONE
                contenSquareIconLeft.visibility = View.GONE

                if(holder == DEFAULT){
                    imageOnlyImage.setImageResource(R.drawable.photoholder_cardview)
                }else{
                    imageOnlyImage.setImageResource(holder)
                    if(uri != ""){
                        Picasso.get().load(uri).into(imageOnlyImage)
                    }
                }
            }
            TYPE_FULL_WITH_IMAGE -> {

                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.VISIBLE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconCenter.visibility = View.GONE
                contenSquareIconLeft.visibility = View.GONE

                if(holder == DEFAULT){
                    imageFullWithImage.setImageResource(R.drawable.photoholder_cardview)
                }else{
                    imageFullWithImage.setImageResource(holder)
                    if(uri != ""){
                        Picasso.get().load(uri).into(imageFullWithImage)
                    }
                }

                if(title != "" && title != null){
                    titleFullWithImage.text = title
                }else{
                    titleFullWithImage.text = resources.getString(R.string.empty_title)
                }

                if(description != "" && description != null){
                    descriptionFullWithImage.text = description
                }else{
                    descriptionFullWithImage.text = resources.getString(R.string.empty_description)
                }

                if(caption != "" && caption != null){
                    captionFullWithImage.text = caption
                }else{
                    captionFullWithImage.text = resources.getString(R.string.empty_caption)
                }

                if(title_color_text == DEFAULT){
                    titleFullWithImage.setTextColor(COLOR_DEFAULT)
                }else{
                    titleFullWithImage.setTextColor(title_color_text)
                }

                if(description_color_text == DEFAULT){
                    descriptionFullWithImage.setTextColor(COLOR_DEFAULT_GRAY)
                }else{
                    descriptionFullWithImage.setTextColor(description_color_text)
                }

                if(caption_color_text == DEFAULT){
                    captionFullWithImage.setTextColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    captionFullWithImage.setTextColor(caption_color_text)
                }

                titleFullWithImage.typeface = Fonts(resources).roboto_bold
                descriptionFullWithImage.typeface = Fonts(resources).roboto_regular
                captionFullWithImage.typeface = Fonts(resources).roboto_regular
                titleFullWithImage.textSize = 16f
                descriptionFullWithImage.textSize = 14f
                captionFullWithImage.textSize = 12f
            }
            TYPE_FULL_WITH_IMAGE_BORDER -> {

                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.VISIBLE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconCenter.visibility = View.GONE
                contenSquareIconLeft.visibility = View.GONE

                if(border == DEFAULT){
                    cardMaskFullWithImageBorder.setCardBackgroundColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    cardMaskFullWithImageBorder.setCardBackgroundColor(border)
                }

                if(holder == DEFAULT){
                    imageFullWithImageBorder.setImageResource(R.drawable.photoholder_cardview)
                }else{
                    imageFullWithImageBorder.setImageResource(holder)
                    if(uri != ""){
                        Picasso.get().load(uri).into(imageFullWithImageBorder)
                    }
                }
                if(title != "" && title != null){
                    titleFullWithImageBorder.text = title
                }else{
                    titleFullWithImageBorder.text = resources.getString(R.string.empty_title)
                }

                if(description != "" && description != null){
                    descriptionFullWithImageBorder.text = description
                }else{
                    descriptionFullWithImageBorder.text = resources.getString(R.string.empty_description)
                }

                if(caption != "" && caption != null){
                    captionFullWithImageBorder.text = caption
                }else{
                    captionFullWithImageBorder.text = resources.getString(R.string.empty_caption)
                }

                if(title_color_text == DEFAULT){
                    titleFullWithImageBorder.setTextColor(COLOR_DEFAULT)
                }else{
                    titleFullWithImageBorder.setTextColor(title_color_text)
                }

                if(description_color_text == DEFAULT){
                    descriptionFullWithImageBorder.setTextColor(COLOR_DEFAULT_GRAY)
                }else{
                    descriptionFullWithImageBorder.setTextColor(description_color_text)
                }

                if(caption_color_text == DEFAULT){
                    captionFullWithImageBorder.setTextColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    captionFullWithImageBorder.setTextColor(caption_color_text)
                }


                titleFullWithImageBorder.typeface = Fonts(resources).roboto_bold
                descriptionFullWithImageBorder.typeface = Fonts(resources).roboto_regular
                captionFullWithImageBorder.typeface = Fonts(resources).roboto_regular
                titleFullWithImageBorder.textSize = 16f
                descriptionFullWithImageBorder.textSize = 14f
                captionFullWithImageBorder.textSize = 12f
            }
            TYPE_SQUARE_ONLY_IMAGE -> {
                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.VISIBLE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconLeft.visibility = View.GONE

                if(holder == DEFAULT){
                    imageSquareOnlyImage.setImageResource(R.drawable.photoholder_cardview)
                }else{
                    imageSquareOnlyImage.setImageResource(holder)
                    if(uri != ""){
                        Picasso.get().load(uri).into(imageSquareOnlyImage)
                    }
                }
            }
            TYPE_SQUARE_ICON_CENTER -> {

                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconCenter.visibility = View.VISIBLE
                contenSquareIconLeft.visibility = View.GONE

                if(title != "" && title != null){
                    titleSquareIconCenter.text = title
                }else{
                    titleSquareIconCenter.text = resources.getString(R.string.empty_title)
                }

                if(subtitle != "" && subtitle != null){
                    subtitleSquareIconCenter.text = title
                }else{
                    subtitleSquareIconCenter.text = resources.getString(R.string.empty_title)
                }

                if(icon == DEFAULT){
                    iconSquareIconCenter.setImageResource(R.drawable.heartic_holder_medium)
                }else {
                    iconSquareIconCenter.setImageResource(icon)
                }

                if(iconTint == DEFAULT){
                    iconSquareIconCenter.setColorFilter(COLOR_DEFAULT_SECONDARY)
                }else{
                    iconSquareIconCenter.setColorFilter(iconTint)
                }

                if(title_color_text == DEFAULT){
                    titleSquareIconCenter.setTextColor(COLOR_DEFAULT_GRAY_LIGHT)
                }else{
                    titleSquareIconCenter.setTextColor(title_color_text)
                }

                if(title_color_text == DEFAULT){
                    subtitleSquareIconCenter.setTextColor(COLOR_DEFAULT_GRAY)
                }else{
                    subtitleSquareIconCenter.setTextColor(title_color_text)
                }

                titleSquareIconCenter.typeface = Fonts(resources).roboto_bold
                subtitleSquareIconCenter.typeface = Fonts(resources).roboto_regular

                titleSquareIconCenter.textSize = 12f
                subtitleSquareIconCenter.textSize = 16f
            }
            TYPE_SQUARE_ICON_LEFT -> {
                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.GONE
                contenSquareIconCenter.visibility = View.GONE
                contenSquareIconLeft.visibility = View.VISIBLE


                if(title != "" && title != null){
                    titleSquareIconLeft.text = title
                }else{
                    titleSquareIconLeft.text = resources.getString(R.string.empty_title)
                }

                if(caption != "" && caption != null){
                    captionSquareIconLeft.text = title
                }else{
                    captionSquareIconLeft.text = resources.getString(R.string.empty_caption)
                }

                if(description != "" && description != null){
                    descriptionSquareIconLeft.text = title
                }else{
                    descriptionSquareIconLeft.text = resources.getString(R.string.empty_description)
                }

                if(icon == DEFAULT){
                    iconSquareIconLeft.setImageResource(R.drawable.heartic_holder_medium)
                }else {
                    iconSquareIconLeft.setImageResource(icon)
                }

                if(iconTint == DEFAULT){
                    iconSquareIconLeft.setColorFilter(COLOR_DEFAULT_SECONDARY)
                }else{
                    iconSquareIconLeft.setColorFilter(iconTint)
                }

                if(title_color_text == DEFAULT){
                    titleSquareIconLeft.setTextColor(COLOR_DEFAULT)
                }else{
                    titleSquareIconLeft.setTextColor(title_color_text)
                }

                if(title_color_text == DEFAULT){
                    captionSquareIconLeft.setTextColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    captionSquareIconLeft.setTextColor(title_color_text)
                }

                if(description_color_text == DEFAULT){
                    descriptionSquareIconLeft.setTextColor(COLOR_DEFAULT_GRAY)
                }else{
                    descriptionSquareIconLeft.setTextColor(title_color_text)
                }


                titleSquareIconCenter.typeface = Fonts(resources).roboto_bold
                subtitleSquareIconCenter.typeface = Fonts(resources).roboto_regular
                descriptionSquareIconLeft.typeface = Fonts(resources).roboto_regular

                titleSquareIconCenter.textSize = 16f
                captionSquareIconLeft.textSize = 10f
                descriptionSquareIconLeft.textSize = 12f

            }
            TYPE_MEDIUM_WITH_IMAGE -> {
                contenOnlyImage.visibility = View.GONE
                contenFullWithImage.visibility = View.GONE
                contenFullWithImageBorder.visibility = View.GONE
                contenSquareOnlyImage.visibility = View.GONE
                contenMediumWithImage.visibility = View.VISIBLE
                contenSquareIconCenter.visibility = View.GONE
                contenSquareIconLeft.visibility = View.GONE

                if(holder == DEFAULT){
                    imageMediumWithImage.setImageResource(R.drawable.photoholder_cardview)
                }else{
                    imageMediumWithImage.setImageResource(holder)
                    if(uri != ""){
                        Picasso.get().load(uri).into(imageMediumWithImage)
                    }
                }

                if(title != "" && title != null){
                    titleMediumWithImage.text = title
                }else{
                    titleMediumWithImage.text = resources.getString(R.string.empty_title)
                }

                if(description != "" && description != null){
                    descriptionMediumWithImage.text = description
                }else{
                    descriptionMediumWithImage.text = resources.getString(R.string.empty_description)
                }

                if(caption != "" && caption != null){
                    captionMediumWithImage.text = caption
                }else{
                    captionMediumWithImage.text = resources.getString(R.string.empty_caption)
                }


                if(titleButton != "" && titleButton != null){
                    val underLine = "<u>$titleButton<u>"
                    buttonMediumWithImage.setText(Html.fromHtml(underLine), TextView.BufferType.SPANNABLE)
                }else{
                    val underLine = "<u>" + resources.getString(R.string.empty_title) +"<u>"
                    buttonMediumWithImage.setText(Html.fromHtml(underLine), TextView.BufferType.SPANNABLE)
                }

                if(title_color_text == DEFAULT){
                    titleMediumWithImage.setTextColor(COLOR_DEFAULT)
                }else{
                    titleMediumWithImage.setTextColor(title_color_text)
                }

                if(description_color_text == DEFAULT){
                    descriptionMediumWithImage.setTextColor(COLOR_DEFAULT_GRAY)
                }else{
                    descriptionMediumWithImage.setTextColor(description_color_text)
                }

                if(caption_color_text == DEFAULT){
                    captionMediumWithImage.setTextColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    captionMediumWithImage.setTextColor(caption_color_text)
                }

                if(button_color_text == DEFAULT){
                    buttonMediumWithImage.setTextColor(COLOR_DEFAULT_SECONDARY)
                }else{
                    buttonMediumWithImage.setTextColor(button_color_text)
                }

                titleMediumWithImage.typeface = Fonts(resources).roboto_bold
                captionMediumWithImage.typeface = Fonts(resources).roboto_regular
                descriptionMediumWithImage.typeface = Fonts(resources).roboto_regular
                buttonMediumWithImage.typeface = Fonts(resources).roboto_medium

                titleFullWithImage.textSize = 16f
                captionMediumWithImage.textSize = 10f
                descriptionMediumWithImage.textSize = 14f
                buttonMediumWithImage.textSize = 14f
            }
        }

        attributes.recycle()
    }


    var uri: String? by Delegates.observable<String?>(null) { _, _, imageUrl ->
        val imageView: ImageView = findViewById(R.id.img_avatar)
        val imageViewHorizotal: ImageView = findViewById(R.id.img_avatar_horizontal)
        Picasso.get().load(imageUrl).resize(pxToDp(40), pxToDp(40)).transform(CircleTransform()).into(imageView)
        Picasso.get().load(imageUrl).resize(pxToDp(40), pxToDp(40)).transform(CircleTransform()).into(imageViewHorizotal)
    }


    companion object {
        const val SMALL = 0
        const val MEDIUM  = 1
        const val LARGE  = 2

        const val HORIZOTAL = 0
        const val VERTICAL  = 1

        const val TYPE_ONLY_IMAGE               = 0
        const val TYPE_FULL_WITH_IMAGE          = 1
        const val TYPE_FULL_WITH_IMAGE_BORDER   = 2
        const val TYPE_SQUARE_ONLY_IMAGE        = 3
        const val TYPE_SQUARE_ICON_CENTER       = 4
        const val TYPE_SQUARE_ICON_LEFT         = 5
        const val TYPE_MEDIUM_WITH_IMAGE        = 6
        const val TYPE_FULL_WITH_BUTTONS        = 7
        const val TYPE_SMALL_WITH_ICON          = 8

        const val DEFAULT     = 0

    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }
}
