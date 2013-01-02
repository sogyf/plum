/*
 * Copyright (c) 2012-2013, Poplar Yfyang 杨友峰 (poplar1123@gmail.com).
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

package plum.freemarker.shiro.role;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import plum.freemarker.shiro.auth.SecureTag;

/**
 * <p>
 * 角色标签，用于判定当前登录人的角色信息.
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-10-27 10:34 AM
 * @since JDK 1.5
 */
public abstract class RoleTag extends SecureTag {

	/**
	 * 获取角色名称，从但前的参数信息中.
	 *
	 * @param params 参数信息
	 * @return 角色名称
	 */
	String getName(Map params) {
		return getParam(params, "name");
	}

	@Override
	public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
		boolean show = showTagBody(getName(params));
		if (show) {
			renderBody(env, body);
		}
	}

	protected abstract boolean showTagBody(String roleName);
}