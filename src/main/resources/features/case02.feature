Feature: TopicFeature

  Scenario: Create new topic
    Given User is authorization
    And User click the button Новая тема
    And User enters the name of the topic "New topic Vegas"
    And User adds a description text "New description"
    When User click the button Опубликовать тему
    Then Topic created and published

  Scenario: Preview new topic
    Given User is authorization
    And User click the button Новая тема
    And User enters the name of the topic "New topic Vegas"
    And User adds a description text "New description"
    When User click the button Предпросмотр
    Then Pop-up message appears Предпросмотр сообщения

#  Scenario: Delete topic
#    Given User is authorization
#    And User click the button Новая тема
#    And User enters the name of the topic "New topic Vegas"
#    And User adds a description text "New description"
#    When User click the button Отмена
#    Then Pop-up message appears "Вы уверены что хотите удалить ветку?"
#    And User click the button Ок
#    Then Topic deleted

  Scenario: Answer in topic
    Given User is authorization
    And User enters topic
    And User click on the button Ответить
    And User adds a description text "New description's answer"
    When User click the button Отправить ответ
    Then A response message appears in the subject

  Scenario: Add Quiz
    Given User is authorization
    And User click the button Новая тема
    And User enters the name of the topic "New topic Vegas"
    And User adds a description text "New description"
    And User click the button Опубликовать тему
    And User click the button Добавить опрос
    And User add quiz question "Question"
    And User add answer options "AnswerOne" and "AnswerTwo"
    When User click the button Сообщение с голосованием
    Then Pop-up message appears "Голосование было опубликовано."
