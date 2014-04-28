package com.illuzor.sharingextension.functions;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import java.util.List;
import android.content.Context;
import android.content.pm.ResolveInfo;

import com.adobe.fre.*;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.pm.PackageInfo;

public class ShareTextFunction implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		try {
			String title = args[0].getAsString();
			String message = args[1].getAsString();
			
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			sharingIntent.putExtra(Intent.EXTRA_TEXT, message);
			context.getActivity().startActivity(Intent.createChooser(sharingIntent, title));
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;
	}

	public Intent findTwitterClient(FREContext context) {
	    final String[] twitterApps = {
	            // package // name - nb installs (thousands)
	            "com.twitter.android", // official - 10 000
	            "com.twidroid", // twidroid - 5 000
	            "com.handmark.tweetcaster", // Tweecaster - 5 000
	            "com.thedeck.android",
	            "com.dotsandlines.carbon" }; // TweetDeck - 5 000 };
	    Intent tweetIntent = new Intent();
	    tweetIntent.setType("text/plain");
	    final PackageManager packageManager = context.getActivity().getPackageManager();
	    
	    List<ResolveInfo> list = packageManager.queryIntentActivities(
	            tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);
	    for (int i = 0; i < twitterApps.length; i++) {
	        for (ResolveInfo resolveInfo : list) {
	            String p = resolveInfo.activityInfo.packageName;
	            if (p != null && p.startsWith(twitterApps[i])) {
	                tweetIntent.setPackage(p);
	                return tweetIntent;
	            }
	        }
	    }
   		return null;
   	}

}
