/**<ul>
 * <li>Cours3TP2ListView</li>
 * <li>com.android2ee.licence.cours3.tp2.listview</li>
 * <li>1 févr. 2012</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage except training and can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.licence.cours3.tp2.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to show the usage of a ListView. It add the element from the EditText in
 *        the ListView
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class Cours3TP2ListViewActivity extends Activity {
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/

	/**
	 * The ArrayAdapter to use
	 */
	private ArrayAdapter<String> arrayAdapter;
	/**
	 * The EditText
	 */
	private EditText editText;
	/**
	 * The ListView
	 */
	private ListView listView;
	/**
	 * The AddButton
	 */
	private Button button; 
	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Building mainLayout
		setContentView(R.layout.main);
		// Retrieve the ListView, EditText and Button
		listView = (ListView) findViewById(R.id.myListView);
		editText = (EditText) findViewById(R.id.editTask);
		button = (Button) findViewById(R.id.addButton);
		// Création de la liste des to do items
		final ArrayList<String> items = new ArrayList<String>();
		// Création de l'array adapter pour lier l'array à la listview
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		// Liaison de l'array adapter à la listview.
		listView.setAdapter(arrayAdapter);
		addListeners();
	}

	/**
	 * Add the listeners to the ListView and the Button
	 */
	private void addListeners() {
		// Add a listener on the listView
		listView.setClickable(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				itemSelected(position);
			}
		});
		// Add the button listener
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				updateList();
			}
		});
	}

	/******************************************************************************************/
	/** Listeners' Methods **************************************************************************/
	/******************************************************************************************/

	/**
	 * Update the EditText according to the selected item
	 * 
	 * @param position
	 */
	private void itemSelected(int position) {
		String item = (String) arrayAdapter.getItem(position);
		editText.setText(item);

	}

	/**
	 * Update the list using the EditText value
	 */
	private void updateList() {
		// Add the value of the EditText in the list
		arrayAdapter.add(editText.getText().toString());
		// Delete the content of the Edit text
		editText.setText("");
	}
}