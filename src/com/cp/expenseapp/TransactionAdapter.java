package com.cp.expenseapp;

import java.util.List;

import com.cp.expenseapp.models.Transaction;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TransactionAdapter extends ArrayAdapter<Transaction> {
	public TransactionAdapter(Context context, List<Transaction> transactions) {
		super(context, 0, transactions);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    View view = convertView;
	    if (view == null) {
	    	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	view = inflater.inflate(R.layout.transaction_item, null);
	    }

        Transaction transaction = getItem(position);
        
        
       
        
        TextView date = (TextView) view.findViewById(R.id.tvDate);
        
        date.setText(Html.fromHtml(transaction.getName()));

        TextView account = (TextView) view.findViewById(R.id.tvAccount);
        account.setText(Html.fromHtml(transaction.getAccount()));
        
        TextView vendor = (TextView) view.findViewById(R.id.tvAccount);
        vendor.setText(Html.fromHtml(transaction.getVendor()));
        
        TextView amount = (TextView) view.findViewById(R.id.tvAccount);
        amount.setText(Html.fromHtml(transaction.getAmount()));
        
        
        
        return view;
	}

}
