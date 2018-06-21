package com.sensedia.movies.suggestion.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sensedia.movies.suggestion.model.movies.Genre;
import com.sensedia.movies.suggestion.model.movies.GenreFactory;

@RunWith(SpringJUnit4ClassRunner.class)
public class GenreFactoryTest {

	@Test
	public void testActionGenre() throws Exception {
		Assert.assertEquals(Genre.ACTION, GenreFactory.getGenre(80));
		Assert.assertEquals(Genre.ACTION, GenreFactory.getGenre(50));
		Assert.assertEquals(Genre.ACTION, GenreFactory.getGenre(41));
		Assert.assertNotEquals(Genre.ACTION, GenreFactory.getGenre(40));
		Assert.assertNotEquals(Genre.ACTION, GenreFactory.getGenre(0));
	}
	
	@Test
	public void testComedyGenre() throws Exception {
		Assert.assertEquals(Genre.COMEDY, GenreFactory.getGenre(36));
		Assert.assertEquals(Genre.COMEDY, GenreFactory.getGenre(37));
		Assert.assertEquals(Genre.COMEDY, GenreFactory.getGenre(38));
		Assert.assertNotEquals(Genre.COMEDY, GenreFactory.getGenre(41));
		Assert.assertNotEquals(Genre.COMEDY, GenreFactory.getGenre(35));
		Assert.assertNotEquals(Genre.COMEDY, GenreFactory.getGenre(0));
	}
	
	@Test
	public void testAnimationGenre() throws Exception {
		Assert.assertEquals(Genre.ANIMATION, GenreFactory.getGenre(21));
		Assert.assertEquals(Genre.ANIMATION, GenreFactory.getGenre(35));
		Assert.assertNotEquals(Genre.ANIMATION, GenreFactory.getGenre(20));
		Assert.assertNotEquals(Genre.ANIMATION, GenreFactory.getGenre(36));
	}
	
	@Test
	public void testThrillerGenre() throws Exception {
		Assert.assertEquals(Genre.THRILLER, GenreFactory.getGenre(1));
		Assert.assertEquals(Genre.THRILLER, GenreFactory.getGenre(20));
		Assert.assertNotEquals(Genre.THRILLER, GenreFactory.getGenre(-1));
		Assert.assertNotEquals(Genre.THRILLER, GenreFactory.getGenre(21));
	}
	
	@Test
	public void testDocumentaryGenre() throws Exception {
		Assert.assertEquals(Genre.DOCUMENTARY, GenreFactory.getGenre(-1));
		Assert.assertEquals(Genre.DOCUMENTARY, GenreFactory.getGenre(0));
		Assert.assertEquals(Genre.DOCUMENTARY, GenreFactory.getGenre(-500));
		Assert.assertNotEquals(Genre.DOCUMENTARY, GenreFactory.getGenre(1));
		Assert.assertNotEquals(Genre.DOCUMENTARY, GenreFactory.getGenre(100));
	}
}
