package com.mobile.ui.sdk.views

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.mobile.ui.sdk.R
import com.mobile.ui.sdk.utils.Fonts
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import kotlin.properties.Delegates


@RequiresApi(Build.VERSION_CODES.O)
class AvatarView(context: Context, attrs: AttributeSet): RelativeLayout(context, attrs) {

    init {
        inflate(context, R.layout.avatar_view, this)

        val contentVertical: RelativeLayout = findViewById(R.id.content_vertical)
        val contentHorizotal: RelativeLayout = findViewById(R.id.content_horizontal)

        val imageView: ImageView = findViewById(R.id.img_avatar)
        val textViewTitle: TextView = findViewById(R.id.title_avatar)
        val textViewSubTitle: TextView = findViewById(R.id.subtitle_avatar)

        val imageViewHorizotal: ImageView = findViewById(R.id.img_avatar_horizontal)
        val textViewTitleHorizotal: TextView = findViewById(R.id.title_avatar_horizontal)
        val textViewSubTitleHorizotal: TextView = findViewById(R.id.subtitle_avatar_horizontal)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.AvatarView)

        textViewTitle.text = attributes.getString(R.styleable.AvatarView_avatar_title)
        textViewSubTitle.text = attributes.getString(R.styleable.AvatarView_avatar_subtitle)

        textViewTitleHorizotal.text = attributes.getString(R.styleable.AvatarView_avatar_title)
        textViewSubTitleHorizotal.text = attributes.getString(R.styleable.AvatarView_avatar_subtitle)

        val size =  attributes.getString(R.styleable.AvatarView_avatar_size)
        val position =  attributes.getString(R.styleable.AvatarView_avatar_position)
        val state =  attributes.getString(R.styleable.AvatarView_avatar_state)

        when (position!!.toInt()){
            HORIZOTAL -> {
                contentVertical.visibility = View.GONE
                contentHorizotal.visibility = View.VISIBLE
                when (size!!.toInt()){
                    SMALL -> {
                        imageViewHorizotal.setImageResource(R.drawable.small_placeholder_avatar)
                        textViewTitleHorizotal.textSize = 14f
                        textViewSubTitleHorizotal.textSize = 12f
                        textViewTitleHorizotal.typeface = Fonts(resources).roboto_medium
                        textViewSubTitleHorizotal.typeface = Fonts(resources).roboto_medium
                    }
                    MEDIUM -> {
                        imageViewHorizotal.setImageResource(R.drawable.medium_placeholder_avatar)
                        textViewTitleHorizotal.textSize = 16f
                        textViewSubTitleHorizotal.textSize = 14f
                        textViewTitleHorizotal.typeface = Fonts(resources).roboto_medium
                        textViewSubTitleHorizotal.typeface = Fonts(resources).roboto_regular
                    }
                    LARGE -> {
                        imageViewHorizotal.setImageResource(R.drawable.large_placeholder_avatar)
                        textViewTitleHorizotal.textSize = 18f
                        textViewSubTitleHorizotal.textSize = 16f
                        textViewTitleHorizotal.typeface = Fonts(resources).roboto_bold
                        textViewSubTitleHorizotal.typeface = Fonts(resources).roboto_regular
                    }
                }

                when (state!!.toInt()){
                    WITH_TEXT -> {
                        textViewTitleHorizotal.visibility = View.VISIBLE
                        textViewSubTitleHorizotal.visibility = View.VISIBLE
                        imageViewHorizotal.visibility = View.VISIBLE
                    }
                    ONLY_IMG -> {
                        textViewTitleHorizotal.visibility = View.GONE
                        textViewSubTitleHorizotal.visibility = View.GONE
                        imageViewHorizotal.visibility = View.VISIBLE
                    }
                }

            }
            VERTICAL -> {
                contentVertical.visibility = View.VISIBLE
                contentHorizotal.visibility = View.GONE
                when (size!!.toInt()){
                    SMALL -> {
                        imageView.setImageResource(R.drawable.small_placeholder_avatar)
                        textViewTitle.textSize = 14f
                        textViewSubTitle.textSize = 12f
                        textViewTitle.typeface = Fonts(resources).roboto_medium
                        textViewSubTitle.typeface = Fonts(resources).roboto_medium
                    }
                    MEDIUM -> {
                        imageView.setImageResource(R.drawable.medium_placeholder_avatar)
                        textViewTitle.textSize = 16f
                        textViewSubTitle.textSize = 14f
                        textViewTitle.typeface = Fonts(resources).roboto_medium
                        textViewSubTitle.typeface = Fonts(resources).roboto_regular
                    }
                    LARGE -> {
                        imageView.setImageResource(R.drawable.large_placeholder_avatar)
                        textViewTitle.textSize = 18f
                        textViewSubTitle.textSize = 16f
                        textViewTitle.typeface = Fonts(resources).roboto_bold
                        textViewSubTitle.typeface = Fonts(resources).roboto_regular
                    }


                }

                when (state!!.toInt()){
                    WITH_TEXT -> {
                        textViewTitle.visibility = View.VISIBLE
                        textViewSubTitle.visibility = View.VISIBLE
                        imageView.visibility = View.VISIBLE
                    }
                    ONLY_IMG -> {
                        textViewTitle.visibility = View.GONE
                        textViewSubTitle.visibility = View.GONE
                        imageView.visibility = View.VISIBLE
                    }
                }
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

        const val ONLY_IMG = 0
        const val WITH_TEXT  = 1
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }
}

class CircleTransform : Transformation {
    override fun transform(source: Bitmap): Bitmap {
        val size = Math.min(source.width, source.height)
        val x = (source.width - size) / 2
        val y = (source.height - size) / 2
        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
        if (squaredBitmap != source) {
            source.recycle()
        }
        val bitmap = Bitmap.createBitmap(size, size, source.config)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        val shader = BitmapShader(
            squaredBitmap,
            Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
        )
        paint.setShader(shader)
        paint.setAntiAlias(true)
        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)
        squaredBitmap.recycle()
        return bitmap
    }

    override fun key(): String {
        return "circle"
    }
}