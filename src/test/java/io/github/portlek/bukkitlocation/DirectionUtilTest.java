package io.github.portlek.bukkitlocation;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.Location;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;

final class DirectionUtilTest {

  private static ServerMock serverMock;

  @BeforeAll
  static void setUp() {
    DirectionUtilTest.serverMock = MockBukkit.mock();
    MockBukkit.load(FakePlugin.class);
    DirectionUtilTest.serverMock.addSimpleWorld("world");
    DirectionUtilTest.serverMock.addPlayer("player");
  }

  @AfterAll
  static void tearDown() {
    MockBukkit.unmock();
  }

  @Test
  void directionOf() {
    final var directions = DirectionUtil.directionOf(100.0f);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }

  @Test
  void doubleDirectionOf() {
    final var directions = DirectionUtil.doubleDirectionOf(100.0f);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }

  @Test
  void testDirectionOf() {
    final var location = new Location(DirectionUtilTest.serverMock.getWorld("world"), 100.0d, 100.0d, 100.0d, 100.0f, 50.0f);
    final var directions = DirectionUtil.directionOf(location);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }

  @Test
  void testDirectionOf1() {
    final var location = new Location(DirectionUtilTest.serverMock.getWorld("world"), 100.0d, 100.0d, 100.0d, 100.0f, 50.0f);
    final var player = DirectionUtilTest.serverMock.getPlayer("player");
    assert player != null;
    player.teleport(location);
    final var directions = DirectionUtil.directionOf(player);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }

  @Test
  void testDoubleDirectionOf() {
    final var location = new Location(DirectionUtilTest.serverMock.getWorld("world"), 100.0d, 100.0d, 100.0d, 100.0f, 50.0f);
    final var directions = DirectionUtil.doubleDirectionOf(location);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }

  @Test
  void testDoubleDirectionOf1() {
    final var location = new Location(DirectionUtilTest.serverMock.getWorld("world"), 100.0d, 100.0d, 100.0d, 100.0f, 50.0f);
    final var player = DirectionUtilTest.serverMock.getPlayer("player");
    assert player != null;
    player.teleport(location);
    final var directions = DirectionUtil.doubleDirectionOf(player);
    new Assertion<>(
      "Couldn't get direction correctly!",
      directions,
      new IsEqual<>(Directions.WEST)
    ).affirm();
  }
}