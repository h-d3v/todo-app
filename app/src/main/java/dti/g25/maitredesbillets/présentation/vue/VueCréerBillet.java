package dti.g25.maitredesbillets.présentation.vue;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurCréerBillet;

public class VueCréerBillet extends Fragment implements ContratVuePrésenteurCréerBillet.IVueCréerBillet {

    private static final String EXTRA_POSITION = "dti.g25.maitredesbillets.position";
    private static final String EXTRA_DESCRIPTION_BILLET = "dti.g25.maitredesbillets.descriptionBillet";
    private static final String EXTRA_TITRE_BILLET = "dti.g25.maitredesbillets.titreBillet";

    private ContratVuePrésenteurCréerBillet.IPrésenteurCréerBillet présenteur;

    private TextView txtTitreBillet;
    private TextView txtDescriptionBillet;
    private Button btnCreerBillet;
    public void setPrésenteur(ContratVuePrésenteurCréerBillet.IPrésenteurCréerBillet présenteur) {
        this.présenteur=présenteur;
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        View racine = inflater.inflate(R.layout.fragement_creer_billet, container, false);

        txtTitreBillet=racine.findViewById(R.id.txtCréeationTitreBillet);
        txtDescriptionBillet=racine.findViewById(R.id.txtDescriptionCréeationBillet);
        btnCreerBillet = racine.findViewById(R.id.btnCreerBillet);
        btnCreerBillet.setEnabled(false);
        txtTitreBillet.addTextChangedListener(billetTextWatcher);
        txtDescriptionBillet.addTextChangedListener(billetTextWatcher);
        btnCreerBillet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                présenteur.terminerÉdition();
            }
        });

        return racine;
    }

    private TextWatcher billetTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (getDescriptionBillet().trim().isEmpty() || getTitreBillet().trim().isEmpty()) {
                btnCreerBillet.setEnabled(false);
            } else if (getTitreBillet().length() > 20) {
                btnCreerBillet.setEnabled(false);
            } else if (getTitreBillet().length() < 2) {
                btnCreerBillet.setEnabled(false);
            } else {
                btnCreerBillet.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public String getTitreBillet() {
        return txtTitreBillet.getText().toString();
    }

    @Override
    public String getDescriptionBillet() {
        return txtDescriptionBillet.getText().toString();
    }

}
