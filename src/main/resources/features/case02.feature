Feature: TopicFeature

  Scenario: Create new topic
    Given User is authorization
    And User click the button Новая тема
    And User enters the name of the topic "New topic Vegas"
    And User adds a description text "New description"
    When User click the button Опубликовать тему
    Then Topic created and published "Ваша тема была опубликована."
#
#  Scenario: Preview new topic
#    Given User is enter
#    And User click the button Новая тема
#    And User enters the name of the topic "New topic Vegas"
#    And User adds a description text "New description"
#    When User click the button Предпросмотр
#    Then Pop-up message appears Предпросмотр сообщения
#
#  Scenario: Delete topic
#    Given User is enter
#    And User click the button Новая тема
#    And User enters the name of the topic "New topic Vegas"
#    And User adds a description text "New description"
#    When User click the button Отмена
#    Then Pop-up message appears Вы уверены что хотите удалить ветку?
#    And User click the button Ок
#    Then Topic deleted





