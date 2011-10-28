/**
 * CursorDataSetProperty.java
 * 11 Oct 2011 Copyright Cheng Wei and Robert Taylor
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
package robobinding.presentationmodel;

import robobinding.beans.PropertyAccessor;



/**
 * 
 * @since 1.0
 * @author Cheng Wei
 * @author Robert Taylor
 */
public class CursorDataSetProperty<T> extends AbstractDataSetProperty<T>
{
	public CursorDataSetProperty(Object bean, PropertyAccessor<Object> propertyAccessor)
	{
		super(bean, propertyAccessor);
	}
	@Override
	public int size()
	{
		TypedCursor<T> cursor = getCursor();
		return cursor.getCount();
	}
	@Override
	public T getItem(int position)
	{
		TypedCursor<T> cursor = getCursor();
		return cursor.getObjectAtPosition(position);
	}
	private TypedCursor<T> getCursor()
	{
		@SuppressWarnings("unchecked")
		TypedCursor<T> cursor = (TypedCursor<T>)getValue();
		return cursor;
	}
}
