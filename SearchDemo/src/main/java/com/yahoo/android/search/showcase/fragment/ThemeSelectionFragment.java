package com.yahoo.android.search.showcase.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yahoo.android.search.showcase.CustomBgSearchActivity;
import com.yahoo.android.search.showcase.R;
import com.yahoo.mobile.client.share.search.settings.SearchSDKSettings;
import com.yahoo.mobile.client.share.search.ui.activity.SearchActivity;

public class ThemeSelectionFragment extends Fragment {

    private static final String TAG = ThemeSelectionFragment.class.getSimpleName();
    private static final String TABS = "tabs";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_theme_selection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // All Search Settings views
        ImageView whiteThemeView = (ImageView) view.findViewById(R.id.demo_search_bar_white_theme);
        ImageView darkThemeView = (ImageView) view.findViewById(R.id.demo_search_bar_dark_theme);
        ImageView transparentThemeView = (ImageView) view.findViewById(R.id.demo_search_bar_transparent_theme);

        // Attach Search Settings Button Preview listener (Same functionality as clicking on the Search Bar)
        whiteThemeView.setOnClickListener(mSearchBarWhiteThemeClickListener);
        darkThemeView.setOnClickListener(mSearchBarDarkThemeClickListener);
        transparentThemeView.setOnClickListener(mSearchBarTransparentThemeClickListener);
    }

    private final View.OnClickListener mSearchBarWhiteThemeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchWhiteThemeSearch();
        }
    };

    private final View.OnClickListener mSearchBarDarkThemeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchDarkThemeSearch();
        }
    };

    private final View.OnClickListener mSearchBarTransparentThemeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchTransparentThemeSearch();
        }
    };

    /**
     * Launch search activity with white theme.
     */
    private void launchWhiteThemeSearch() {
        SearchSDKSettings.setSearchSuggestEnabled(true);
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra(SearchActivity.HEADER_RESOURCE_KEY, R.layout.search_view_custom_header_white);
        intent.putExtra(SearchActivity.FOOTER_RESOURCE_KEY, R.layout.search_view_custom_footer_white);
        startActivity(intent);
    }

    /**
     * Launch Search Activity with dark theme.
     */
    private void launchDarkThemeSearch() {
        SearchSDKSettings.setSearchSuggestEnabled(true);
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra(SearchActivity.HEADER_RESOURCE_KEY, R.layout.search_view_custom_header_dark);
        intent.putExtra(SearchActivity.FOOTER_RESOURCE_KEY, R.layout.search_view_custom_footer_dark);
        startActivity(intent);
    }

    /**
     * Launch Search Activity with blue theme with background image.
     */
    private void launchTransparentThemeSearch() {
        SearchSDKSettings.setSearchSuggestEnabled(true);
        Intent intent = new Intent(getActivity(), CustomBgSearchActivity.class);
        intent.putExtra(SearchActivity.HEADER_RESOURCE_KEY, R.layout.search_view_custom_header_blue);
        intent.putExtra(SearchActivity.FOOTER_RESOURCE_KEY, R.layout.search_view_custom_footer_blue);
        startActivity(intent);
    }
}
