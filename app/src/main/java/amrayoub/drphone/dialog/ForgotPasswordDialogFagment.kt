package amrayoub.drphone.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.widget.Toast
import amrayoub.drphone.R


class ForgotPasswordDialogFagment : DialogFragment() {

    private var listener: OnFragmentInteractionListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        //builder.setView(R.id.)
        // Get the layout inflater
        // Get the LayoutInflater from Context
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(layoutInflater.inflate(R.layout.dialog_forgot_password, null))

        builder.setMessage(R.string.dialog_message)
            .setTitle(R.string.dialog_title)
        builder.setPositiveButton("Send") { dialog, which ->
            Toast.makeText(context, "Pressed", Toast.LENGTH_SHORT).show()
        }

        val dialog: AlertDialog = builder.create()
        // Display the alert dialog on app interface
        dialog.show()
        return dialog
    }

    interface OnFragmentInteractionListener
}
