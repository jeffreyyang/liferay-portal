/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.search.elasticsearch6.internal.ElasticsearchIndexingFixture;
import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch6.internal.connection.LiferayIndexCreator;
import com.liferay.portal.search.test.util.facet.BaseClassicModifiedFacetTestCase;
import com.liferay.portal.search.test.util.indexing.BaseIndexingTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author André de Oliveira
 */
public class ClassicModifiedFacetTest extends BaseClassicModifiedFacetTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		ElasticsearchFixture elasticsearchFixture = new ElasticsearchFixture(
			getClass());

		ElasticsearchIndexingFixture elasticsearchIndexingFixture =
			new ElasticsearchIndexingFixture(
				elasticsearchFixture, BaseIndexingTestCase.COMPANY_ID,
				new LiferayIndexCreator(elasticsearchFixture));

		elasticsearchIndexingFixture.setFacetProcessor(
			new ModifiedFacetProcessor());

		return elasticsearchIndexingFixture;
	}

}