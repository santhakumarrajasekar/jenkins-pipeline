FROM python:2.7

COPY . /app
WORKDIR /app

RUN pip install --upgrade setuptools; \
    pip install --upgrade pip; \
    pip install -r requirements.txt

ENV PYTHONUNBUFFERED="True"

EXPOSE 8888

CMD gunicorn runserver:app \
--enable-stdio-inheritance \
--log-level "debug" \
--error-logfile "-" \
-p /tmp/test.pid \
-b 0.0.0.0:8888 \
-w 8
