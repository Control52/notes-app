# Этап сборки
FROM node:20-alpine AS build

WORKDIR /app

# Копируем файлы зависимостей
COPY package*.json ./

# Устанавливаем зависимости
RUN npm ci --only=production

# Копируем исходный код
COPY . .

# Собираем приложение
RUN npm run build

# Этап запуска - используем Nginx для раздачи статики
FROM nginx:alpine

# Копируем собранное приложение
COPY --from=build /app/dist /usr/share/nginx/html

# Копируем кастомную конфигурацию Nginx (если нужна)
# COPY nginx.conf /etc/nginx/nginx.conf

# Открываем порт
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]