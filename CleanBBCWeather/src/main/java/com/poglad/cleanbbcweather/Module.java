package com.poglad.cleanbbcweather;

import android.view.View;
import android.widget.ImageView;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

/**
 * Created by Paul on 28/12/13.
 */
public class Module implements IXposedHookInitPackageResources
{
    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable
    {
	if (!resparam.packageName.equals("bbc.mobile.weather"))
	    return;

	XC_LayoutInflated layoutInflated = new XC_LayoutInflated()
	{
	    @Override
	    public void handleLayoutInflated(XC_LayoutInflated.LayoutInflatedParam liparam) throws Throwable
	    {
		ImageView widgetAmbience = (ImageView) liparam.view.findViewById(
			liparam.res.getIdentifier("widgetAmbience", "id", "bbc.mobile.weather"));

		widgetAmbience.setVisibility(View.INVISIBLE);
	    }
	};

	resparam.res.hookLayout("bbc.mobile.weather", "layout", "widget_2x1_content", layoutInflated);
	resparam.res.hookLayout("bbc.mobile.weather", "layout", "widget_4x1_content", layoutInflated);
	resparam.res.hookLayout("bbc.mobile.weather", "layout", "widget_4x2_content", layoutInflated);
    }
}