/*
 * Copyright 2011 Google Inc.
 * Copyright 2011 Peter Kuterna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.peterkuterna.android.apps.devoxxsched.ui;

import net.peterkuterna.android.apps.devoxxsched.util.ActivityHelper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.Menu;
import android.support.v4.view.MenuItem;

public abstract class AbstractActivity extends FragmentActivity implements
		BaseActivity {

	final ActivityHelper mActivityHelper = ActivityHelper.createInstance(this);

	@Override
	public void onContentChanged() {
		super.onContentChanged();

		mActivityHelper.setActionBarTextStyle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return mActivityHelper.onCreateOptionsMenu(menu)
				|| super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mActivityHelper.onOptionsItemSelected(item)
				|| super.onOptionsItemSelected(item);
	}

	/**
	 * Returns the {@link ActivityHelper} object associated with this activity.
	 */
	public ActivityHelper getActivityHelper() {
		return mActivityHelper;
	}

	@Override
	public void openActivityOrFragment(Intent intent) {
		mActivityHelper.openActivityOrFragment(intent);
	}

	@Override
	public Bundle intentToFragmentArguments(Intent intent) {
		return ActivityHelper.intentToFragmentArguments(intent);
	}

	@Override
	public Intent fragmentArgumentsToIntent(Bundle arguments) {
		return ActivityHelper.fragmentArgumentsToIntent(arguments);
	}

}
