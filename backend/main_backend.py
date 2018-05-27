import urllib
import flask
app = flask.Flask(__name__)

from urllib import request
# @app.route('/home/')
# def function():
#     return 'Hello World!'


class User:
    lastId = -1
    users_dict = {}

    def __init__(self):
        self.id = str(User.lastId + 1)
        User.lastId += 1
        User.users_dict[self.id] = self

    def getId(self):
        return self.id

@app.route('/user/newId')
def make_new_user(__name__):
    new_user = User()
    id = new_user.getId()
    str_id = id
    return str_id

@app.route("/user/<uid>/edit", methods=['POST'])
def edit_user(uid):
    if request.json is not None and "username" in request.json:
        User.users_dict[uid].name = request.json["username"]


if __name__ == "__main__":
    app.run()