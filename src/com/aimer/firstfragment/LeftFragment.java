package com.aimer.firstfragment;

import java.io.IOException;
import java.io.InputStream;

import android.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LeftFragment extends Fragment implements OnItemClickListener {

	private String[] data = new String[] { "鐏甸瓊鎴樿溅", "鍙樺舰閲戝垰3", "鏁㈡闃�" };
	private ListView listView;

	public View onCreateView(android.view.LayoutInflater inflater,
			android.view.ViewGroup container,
			android.os.Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.left_fragment, null);
		listView = (ListView) view.findViewById(R.id.listview_movie_list);
		listView.setOnItemClickListener(this);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(arrayAdapter);
		listView.setChoiceMode(listView.CHOICE_MODE_SINGLE);// listview鍗曢�妯″紡
		return view;
	};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		TextView textView = (TextView) getActivity().findViewById(
				R.id.textView_detail);
		try {
			InputStream is = getActivity().getAssets().open("m" + position);
			byte[] buffer = new byte[1024];
			int count = is.read(buffer);
			String detailString = new String(buffer, 0, count, "utf-8");
			if (textView == null) {
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				intent.putExtra("detail", detailString);
				startActivity(intent);
			} else {
				textView.setText(detailString);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
