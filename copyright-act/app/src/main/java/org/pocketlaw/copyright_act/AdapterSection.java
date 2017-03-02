package org.pocketlaw.copyright_act;

/**
 * Created by gcgol on 01/06/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterSection extends ArrayAdapter<Section> {


    private Context mContext;

    // Layouts
    private LinearLayout subsectionParagraphLayout;
    private LinearLayout subMarginalLayout;
    private LinearLayout marginalLayout;
    private LinearLayout sectionLayout;
    private LinearLayout subSectionLayout;
    private LinearLayout paragraphLayout;
    private LinearLayout headingLayout;
    private LinearLayout subparagraphLayout;
    private LinearLayout subsectionSubparagraphLayout;
    private LinearLayout definedNameLayout;
    private LinearLayout definitionTextLayout;
    private LinearLayout historicalLayout;
    private LinearLayout continuedParagraphLayout;
    private LinearLayout continuedSubsectionParagraphLayout;
    private LinearLayout continuedSubsectionLayout;



    public AdapterSection(Context context, int resource, List<Section> objects) {
        super(context, resource, objects);

        mContext = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.card_section, parent, false);
        }

        // Heading text/number
        TextView headingText = (TextView) convertView.findViewById(R.id.heading_text);
        TextView headingNumber = (TextView) convertView.findViewById(R.id.heading_number);

        // Subsection text/number
        TextView subtext = (TextView) convertView.findViewById(R.id.sub_text);
        TextView subnumber = (TextView) convertView.findViewById(R.id.sub_number);

        //Definition name
        TextView definedName = (TextView) convertView.findViewById(R.id.defined_name);

        //Definition Text
        TextView definitionText = (TextView) convertView.findViewById(R.id.defined_text);

        // Paragraph text/number
        TextView paratext = (TextView) convertView.findViewById(R.id.para_text);
        TextView paranumber = (TextView) convertView.findViewById(R.id.para_number);

        // Continued Paragraph text/number
        TextView continuedParatext = (TextView) convertView.findViewById(R.id.cont_para_text);
        TextView continuedParanumber = (TextView) convertView.findViewById(R.id.cont_para_number);

        // Continued Subsection Paragraph text/number
        TextView continuedSubsectionParaText = (TextView) convertView.findViewById(R.id.cont_subsection_para_text);
        TextView continuedSubsectionParaNumber = (TextView) convertView.findViewById(R.id.cont_subsection_para_number);

        // Continued Subsection text/number
        TextView continuedSubsectionText = (TextView) convertView.findViewById(R.id.cont_sub_text);
        TextView continuedSubsectionNumber = (TextView) convertView.findViewById(R.id.cont_sub_number);

        // Paragraph text/number
        TextView subsectionParatext = (TextView) convertView.findViewById(R.id.subsection_para_text);
        TextView subsectionParanumber = (TextView) convertView.findViewById(R.id.subsection_para_number);


        // Section text/number
        TextView section = (TextView) convertView.findViewById(R.id.section);
        TextView text = (TextView) convertView.findViewById(R.id.text_section);

        // MarginalNote text
        TextView marginalNote = (TextView) convertView.findViewById(R.id.heading);
        TextView marginalNumber = (TextView) convertView.findViewById(R.id.marginal_number);

        // SubMarginalNote text/number
        TextView subMarginalNote = (TextView) convertView.findViewById(R.id.submarginal_note);

        // Subparagraph text/number
        TextView subParaText = (TextView) convertView.findViewById(R.id.subpara_text);
        TextView subParaNumber = (TextView) convertView.findViewById(R.id.subpara_number);

        // Subsection Subparagraph text/number
        TextView subsectionSubParaText = (TextView) convertView.findViewById(R.id.subsection_subpara_text);
        TextView subsectionSubParaNumber = (TextView) convertView.findViewById(R.id.subsection_subpara_number);

        // HistoricalNote
        TextView historicalNote = (TextView) convertView.findViewById(R.id.historical_note);

        subsectionParagraphLayout = (LinearLayout) convertView.findViewById(R.id.subsection_paragraph_layout);
        subMarginalLayout = (LinearLayout) convertView.findViewById(R.id.submarginal_layout);
        marginalLayout = (LinearLayout) convertView.findViewById(R.id.marginal_layout);
        sectionLayout = (LinearLayout) convertView.findViewById(R.id.section_layout);
        subSectionLayout = (LinearLayout) convertView.findViewById(R.id.subsection_layout);
        paragraphLayout = (LinearLayout) convertView.findViewById(R.id.paragraph_layout);
        continuedParagraphLayout = (LinearLayout) convertView.findViewById(R.id.cont_paragraph_layout);
        headingLayout = (LinearLayout) convertView.findViewById(R.id.heading_layout);
        subparagraphLayout = (LinearLayout) convertView.findViewById(R.id.subparagraph_layout);
        subsectionSubparagraphLayout = (LinearLayout) convertView.findViewById(R.id.subsection_subparagraph_layout);
        definedNameLayout = (LinearLayout) convertView.findViewById(R.id.defined_name_layout);
        definitionTextLayout = (LinearLayout) convertView.findViewById(R.id.definition_text_layout);
        historicalLayout = (LinearLayout) convertView.findViewById(R.id.historical_layout);
        continuedSubsectionParagraphLayout = (LinearLayout) convertView.findViewById(R.id.cont_subsection_paragraph_layout);
        continuedSubsectionLayout = (LinearLayout) convertView.findViewById(R.id.cont_subsection_layout);



        final Section current = getItem(position);

        //TODO: probably remove this CURRENT ITEM log altogether
      //  Log.e("CURRENT ITEM","" + "pinpoint: " + current.getPinpoint() + ", section: " + current.getSection() + ", text: " + current.getFulltext() + ", type: " + current.getType());

        // hide all predefined views to allow visibility setting via type
        hideAll();

        // Section Heading
        if (current.getType() == 0) {

            headingText.setText("" + current.getFulltext());
            headingNumber.setText("" + current.getSection());

            headingLayout.setVisibility(View.VISIBLE);

            // Section MarginalNote
        } else if (current.getType() == 1) {

            marginalNote.setText("" + current.getFulltext());
     //       marginalNumber.setText("" + current.getSection());

            marginalLayout.setVisibility(View.VISIBLE);

            // Section Text
        } else if (current.getType() == 2) {

            text.setText("" + current.getFulltext());
            section.setText(""+current.getSection());

            sectionLayout.setVisibility(View.VISIBLE);

            // Section Subsection Text
        } else if (current.getType() == 3) {

            subtext.setText("" + current.getFulltext());
            if(current.getPinpoint().equals("(1)")) {
                subnumber.setText("" + current.getSection() + current.getPinpoint());
            } else {
                subnumber.setText("" + current.getPinpoint());
            }

            subSectionLayout.setVisibility(View.VISIBLE);

            // Section Paragraph
        } else if (current.getType() == 4) {

            paratext.setText("" + current.getFulltext());
            paranumber.setText("" + current.getPinpoint());

            paragraphLayout.setVisibility(View.VISIBLE);

            // Subsection SubmarginalNote
        } else if (current.getType() == 5) {

            subMarginalNote.setText("" + current.getFulltext());

            subMarginalLayout.setVisibility(View.VISIBLE);

            // Subsection paragraph
        } else if (current.getType() == 6) {

            subsectionParatext.setText("" + current.getFulltext());
            subsectionParanumber.setText("" + current.getPinpoint());

            subsectionParagraphLayout.setVisibility(View.VISIBLE);

            // Subparagraph
        } else if (current.getType() == 7) {

            subParaText.setText("" + current.getFulltext());
            subParaNumber.setText("" + current.getPinpoint());

            subparagraphLayout.setVisibility(View.VISIBLE);

            // Subsection subParagraph
        } else if (current.getType() == 8) {

            subsectionSubParaText.setText("" + current.getFulltext());
            subsectionSubParaNumber.setText("" + current.getPinpoint());

            subsectionSubparagraphLayout.setVisibility(View.VISIBLE);

            // HistoricalNote
        } else if (current.getType() == 9) {

            historicalNote.setText("" + current.getFulltext());

            historicalLayout.setVisibility(View.VISIBLE);

            // Definition english name
        } else if (current.getType() == 10) {

            definedName.setText("" + current.getFulltext());

            definedNameLayout.setVisibility(View.VISIBLE);


            // Definition MarginalNote
        } else if (current.getType() == 11) {

            definitionText.setText("" + current.getFulltext());

            definitionTextLayout.setVisibility(View.VISIBLE);

            // Section Paragraph
        } else if (current.getType() == 12) {

            continuedParatext.setText("" + current.getFulltext());
            continuedParanumber.setText("" + current.getPinpoint());

            continuedParagraphLayout.setVisibility(View.VISIBLE);

        } else if (current.getType() == 13) {

            continuedSubsectionParaText.setText("" + current.getFulltext());
            continuedSubsectionParaNumber.setText("" + current.getPinpoint());

            continuedSubsectionParagraphLayout.setVisibility(View.VISIBLE);

        } else if (current.getType() == 14) {

            continuedSubsectionText.setText("" + current.getFulltext());
            continuedSubsectionNumber.setText("" + current.getPinpoint());

            continuedSubsectionLayout.setVisibility(View.VISIBLE);

        } else {

        }






        //TODO: do stuff with corresponding provision on click
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;


    }

    private void hideAll() {

        definitionTextLayout.setVisibility(View.GONE);
        definedNameLayout.setVisibility(View.GONE);
        marginalLayout.setVisibility(View.GONE);
        sectionLayout.setVisibility(View.GONE);
        subsectionParagraphLayout.setVisibility(View.GONE);
        subMarginalLayout.setVisibility(View.GONE);
        subSectionLayout.setVisibility(View.GONE);
        historicalLayout.setVisibility(View.GONE);
        paragraphLayout.setVisibility(View.GONE);
        headingLayout.setVisibility(View.GONE);
        subparagraphLayout.setVisibility(View.GONE);
        subsectionSubparagraphLayout.setVisibility(View.GONE);
        continuedParagraphLayout.setVisibility(View.GONE);
        continuedSubsectionParagraphLayout.setVisibility(View.GONE);
        continuedSubsectionLayout.setVisibility(View.GONE);

        //TODO: consider nulling all textviews as well

    }


}