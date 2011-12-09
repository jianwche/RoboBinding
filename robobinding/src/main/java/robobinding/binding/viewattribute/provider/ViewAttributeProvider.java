/**
 * Copyright 2011 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package robobinding.binding.viewattribute.provider;

import robobinding.binding.BindingAttributeResolver;
import robobinding.binding.viewattribute.BackgroundColorAttribute;
import robobinding.binding.viewattribute.EnabledAttribute;
import robobinding.binding.viewattribute.OnClickAttribute;
import robobinding.binding.viewattribute.OnLongClickAttribute;
import robobinding.binding.viewattribute.VisibilityAttribute;
import android.view.View;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class ViewAttributeProvider implements BindingAttributeProvider<View>
{
	private static final String VISIBILITY = "visibility";
	private static final String ENABLED = "enabled";
	private static final String ON_CLICK = "onClick";
	private static final String ON_LONG_CLICK = "onLongClick";
	private static final String BACK_GROUND_COLOR = "backgroundColor";
	@Override
	public void resolveSupportedBindingAttributes(View view, BindingAttributeResolver bindingAttributeResolver, boolean preInitializeView)
	{
		if (bindingAttributeResolver.hasAttribute(VISIBILITY))
		{
			String attributeValue = bindingAttributeResolver.findAttributeValue(VISIBILITY);
			bindingAttributeResolver.resolveAttribute(VISIBILITY, new VisibilityAttribute(view, attributeValue, preInitializeView));
		}
		if (bindingAttributeResolver.hasAttribute(ENABLED))
		{
			String attributeValue = bindingAttributeResolver.findAttributeValue(ENABLED);
			bindingAttributeResolver.resolveAttribute(ENABLED, new EnabledAttribute(view, attributeValue, preInitializeView));
		}
		if (bindingAttributeResolver.hasAttribute(ON_CLICK))
		{
			String attributeValue = bindingAttributeResolver.findAttributeValue(ON_CLICK);
			bindingAttributeResolver.resolveAttribute(ON_CLICK, new OnClickAttribute(view, attributeValue));
		}
		if (bindingAttributeResolver.hasAttribute(ON_LONG_CLICK))
		{
			String attributeValue = bindingAttributeResolver.findAttributeValue(ON_LONG_CLICK);
			bindingAttributeResolver.resolveAttribute(ON_LONG_CLICK, new OnLongClickAttribute(view, attributeValue));
		}
		if(bindingAttributeResolver.hasAttribute(BACK_GROUND_COLOR))
		{
			String attributeValue = bindingAttributeResolver.findAttributeValue(BACK_GROUND_COLOR);
			bindingAttributeResolver.resolveAttribute(BACK_GROUND_COLOR, new BackgroundColorAttribute(view, attributeValue, preInitializeView));
		}
	}
}
