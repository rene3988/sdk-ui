# sdk-ui
UI for controls in app


-- Avatar ---
Properties 
    <declare-styleable name="AvatarView">
        <attr name="avatar_title" format="string" />
        <attr name="avatar_uri" format="string" />
        <attr name="avatar_subtitle" format="string" />
        <attr name="avatar_size" format="enum">
            <enum name="small" value="0" />
            <enum name="medium" value="1" />
            <enum name="large" value="2" />
        </attr>
        <attr name="avatar_position" format="enum">
            <enum name="horizontal" value="0" />
            <enum name="vertical" value="1" />
        </attr>
        <attr name="avatar_state" format="enum">
            <enum name="only_image" value="0" />
            <enum name="with_text" value="1" />
        </attr>
    </declare-styleable>


-- Buttons ---
Properties 
     <declare-styleable name="ButtonView">
        <attr name="button_title" format="string" />
        <attr name="button_icon" format="integer" />
        <attr name="button_border" format="integer" />
        <attr name="button_background" format="integer" />
        <attr name="button_text_color" format="integer" />
        <attr name="button_tint_color" format="integer" />

        <attr name="button_type" format="enum">
            <enum name="primary" value="0" />
            <enum name="secondary" value="1" />
            <enum name="icon" value="2" />
            <enum name="text" value="3" />
        </attr>

        <attr name="button_size" format="enum">
            <enum name="small" value="0" />
            <enum name="medium" value="1" />
            <enum name="large" value="2" />
        </attr>

        <attr name="button_state" format="enum">
            <enum name="select" value="0" />
            <enum name="unselect" value="1" />
        </attr>

        <attr name="button_specification" format="enum">
            <enum name="with_brackground" value="0" />
            <enum name="only_border" value="1" />
            <enum name="only_text" value="3" />
            <enum name="only_icon" value="4" />
        </attr>

  </declare-styleable>
  
  
  -- CardView ---
Properties 
     <declare-styleable name="CardCustomView">

        <attr name="card_title" format="string" />
        <attr name="card_subtitle" format="string" />
        <attr name="card_description" format="string" />
        <attr name="card_caption" format="string" />
        <attr name="card_uri" format="string" />
        <attr name="card_holder" format="integer" />
        <attr name="card_icon" format="integer" />
        <attr name="card_icon_tint" format="integer" />
        <attr name="card_border_color" format="integer" />
        <attr name="card_button_text_color" format="integer" />
        <attr name="card_title_button" format="string" />
        <attr name="card_title_text_color" format="integer" />
        <attr name="card_subtitle_text_color" format="integer" />
        <attr name="card_caption_text_color" format="integer" />
        <attr name="card_descriptioncaption_text_color" format="integer" />

        <attr name="card_type" format="enum">
            <enum name="only_image" value="0" />
            <enum name="full_with_image" value="1" />
            <enum name="full_with_image_border" value="2" />
            <enum name="square_only_image" value="3" />
            <enum name="square_icon_center" value="4" />
            <enum name="square_icon_left" value="5" />
            <enum name="medium_with_image" value="6" />
            <enum name="full_with_buttons" value="7" />
            <enum name="small_with_image" value="8" />
        </attr>

        <attr name="card_state" format="enum">
            <enum name="select" value="0" />
            <enum name="unselect" value="1" />
        </attr>

    </declare-styleable>
   
   
   
