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
package robobinding.beans;

import java.text.MessageFormat;




/**
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 *
 */
class SimpleProperty<T> extends AbstractProperty<T>
{
	public SimpleProperty(Object bean, PropertyAccessor<T> propertyAccessor)
	{
		super(bean, propertyAccessor);
	}
	@Override
	public String toString()
	{
		Object value = propertyAccessor.safeGetValue(bean);
		String beanType = bean.getClass().getName();
		String setter = propertyAccessor.safeGetWriteMethodName();
		String getter = propertyAccessor.safeGetReadMethodName();
		return MessageFormat.format("property(name:{0}, value:{1}, propertyType:{2}, setter:{3}, getter:{4}, beanType:{5})", 
				propertyAccessor.getPropertyName(), value, propertyAccessor.getPropertyType(), setter, getter, beanType);

	}
}
